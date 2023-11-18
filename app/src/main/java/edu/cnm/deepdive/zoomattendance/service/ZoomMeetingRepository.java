package edu.cnm.deepdive.zoomattendance.service;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.lifecycle.LiveData;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.zoomattendance.R;
import edu.cnm.deepdive.zoomattendance.model.dao.ZoomMeetingDao;
import edu.cnm.deepdive.zoomattendance.model.dto.Authentication;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ZoomMeetingRepository {

  private final ZoomMeetingDao zoomMeetingDao;
  private final ZoomApiProxy proxy;
  private final String accountId;
  private final String clientId;
  private final String clientSecret;

  private Authentication authentication;

  @Inject
  public ZoomMeetingRepository(@ApplicationContext Context context, ZoomMeetingDao zoomMeetingDao,
      ZoomApiProxy proxy) {
    this.zoomMeetingDao = zoomMeetingDao;
    this.proxy = proxy;
    accountId = context.getString(R.string.account_id);
    clientId = context.getString(R.string.client_id);
    clientSecret = context.getString(R.string.client_secret);
  }

  public Single<Authentication> authenticate() {
    byte[] bytes = (clientId + ':' + clientSecret).getBytes(StandardCharsets.UTF_8);
    String authorization = Base64.encodeToString(bytes, Base64.NO_WRAP);
    return proxy.authenticate("Basic " + authorization, accountId, "account_credentials")
        .subscribeOn(Schedulers.io())
        .doOnSuccess(auth -> authentication = auth);

  }

  public Single<ZoomMeeting> insert(ZoomMeeting zoomMeeting) {
    return zoomMeetingDao
        .insert(zoomMeeting)
        .map(id -> {
          zoomMeeting.setId(id);
          return zoomMeeting;
        })
        .subscribeOn(Schedulers.io());
  }

  public Completable delete(ZoomMeeting zoomMeeting) {
    return zoomMeetingDao
        .delete(zoomMeeting)
        .ignoreElement()
        .subscribeOn(Schedulers.io());
  }

  public LiveData<ZoomMeeting> select(long id) {
    return zoomMeetingDao.select(id);
  }

  public LiveData<List<ZoomMeeting>> selectByStudentId(long studentId) {
    return zoomMeetingDao.selectByStudentId(studentId);
  }

  public LiveData<List<ZoomMeeting>> get() {
    return zoomMeetingDao.get();
  }

  ;

  public Single<? extends List<ZoomMeeting>> list(String userId) {
    return Single.just(
            new LinkedList<ZoomMeeting>(/* TODO Invoke proxy method to construct a request for a meeting list */))
        .map((meetings) -> meetings /* TODO Store return meetings in database  */)
        .subscribeOn(Schedulers.io());
  }

private Single<String> refresh() {
    return (authentication != null && authentication.expiration().after(new Date()))
        ? Single.just("Bearer " + authentication.getToken())
        : authenticate().map((auth) -> "Bearer " + auth.getToken());
}

}
