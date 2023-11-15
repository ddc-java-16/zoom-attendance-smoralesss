package edu.cnm.deepdive.zoomattendance.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import edu.cnm.deepdive.zoomattendance.service.ZoomMeetingRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import javax.inject.Inject;

public class ZoomMeetingViewModel {

  private final ZoomMeetingRepository repository;
  private final MutableLiveData<Long> zoomMeetingId;
  private final LiveData<ZoomMeeting> zoomMeeting;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  @Inject
  ZoomMeetingViewModel(@ApplicationContext ZoomMeetingRepository repository, MutableLiveData<Long> zoomMeetingId,
      LiveData<ZoomMeeting> zoomMeeting, MutableLiveData<Throwable> throwable,
      CompositeDisposable pending) {
    this.repository = repository;
    this.zoomMeetingId = zoomMeetingId;
    this.zoomMeeting = zoomMeeting;
    this.throwable = throwable;
    this.pending = pending;
  }
}
