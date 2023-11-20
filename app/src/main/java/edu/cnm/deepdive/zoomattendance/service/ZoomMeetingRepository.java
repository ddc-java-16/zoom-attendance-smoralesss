package edu.cnm.deepdive.zoomattendance.service;

import android.content.Context;
import android.util.Base64;
import androidx.lifecycle.LiveData;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.zoomattendance.R;
import edu.cnm.deepdive.zoomattendance.model.dao.ZoomMeetingDao;
import edu.cnm.deepdive.zoomattendance.model.dto.Authentication;
import edu.cnm.deepdive.zoomattendance.model.dto.Meeting;
import edu.cnm.deepdive.zoomattendance.model.dto.MeetingListResponse;
import edu.cnm.deepdive.zoomattendance.model.dto.MeetingParticipantsResponse;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ZoomMeetingRepository {

  private static final String DATE_FORMAT = "yyyy-MM-dd";
  private static final int PAGE_SIZE = 300;

  private final ZoomMeetingDao zoomMeetingDao;
  private final ZoomAuthProxy authProxy;
  private final ZoomApiProxy apiProxy;
  private final String accountId;
  private final String clientId;
  private final String clientSecret;
  private final DateFormat dateFormat;

  private Authentication authentication;

  @Inject
  public ZoomMeetingRepository(@ApplicationContext Context context, ZoomMeetingDao zoomMeetingDao,
      ZoomAuthProxy authProxy, ZoomApiProxy apiProxy) {
    this.zoomMeetingDao = zoomMeetingDao;
    this.authProxy = authProxy;
    this.apiProxy = apiProxy;
    accountId = context.getString(R.string.account_id);
    clientId = context.getString(R.string.client_id);
    clientSecret = context.getString(R.string.client_secret);
    dateFormat = new SimpleDateFormat(DATE_FORMAT);
  }

  public Single<Authentication> authenticate() {
    byte[] bytes = (clientId + ':' + clientSecret).getBytes(StandardCharsets.UTF_8);
    String authorization = Base64.encodeToString(bytes, Base64.NO_WRAP);
    return authProxy.authenticate("Basic " + authorization, accountId, "account_credentials")
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
        .map((meetings) -> meetings /* TODO Store return meetings in database  */);
  }

  private Single<String> refresh() {
    return (
        (authentication != null && authentication.expiration().after(new Date()))
            ? Single.just("Bearer " + authentication.getToken())
            : authenticate().map((auth) -> "Bearer " + auth.getToken())
    )
        .subscribeOn(Schedulers.io());
  }

  public Single<List<Meeting>> fetchMeetings(Date from, Date to) {
    return refresh()
        .flatMap(token -> apiProxy.listMeetings(token, "", dateFormat.format(from),
            dateFormat.format(to), PAGE_SIZE))
        .map(MeetingListResponse::getMeetings);
  }

  public Completable observeMeetings(Date from, Date to) {
    return fetchMeetings(from, to)
        .flatMapObservable(Observable::fromIterable)
        .flatMap(meeting -> apiProxy.listParticipants("Bearer " + authentication.getToken(), meeting.getUuid(), "")
            .map(MeetingParticipantsResponse::getParticipants)
            .flatMapObservable(Observable::fromIterable)
            .doOnNext((participant) -> { /* TODO Take the meeting & the participant and store them in the database (as instances of ZoomMeeting class and Student class */ }))
        .ignoreElements();
  }

}
