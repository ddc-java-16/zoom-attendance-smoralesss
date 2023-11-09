package edu.cnm.deepdive.zoomattendance.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.zoomattendance.model.dao.ZoomMeetingDao;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ZoomMeetingRepository {

  private final ZoomMeetingDao zoomMeetingDao;

  @Inject
  public ZoomMeetingRepository(ZoomMeetingDao zoomMeetingDao) {this.zoomMeetingDao = zoomMeetingDao;}

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
    return zoomMeetingDao.select(studentId);
  }

  public LiveData<List<ZoomMeeting>> get() {
    return zoomMeetingDao.get();
  };

}
