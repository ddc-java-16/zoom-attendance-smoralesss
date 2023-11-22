package edu.cnm.deepdive.zoomattendance.viewmodel;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import edu.cnm.deepdive.zoomattendance.service.ZoomMeetingRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

@HiltViewModel
public class ZoomMeetingViewModel extends ViewModel implements DefaultLifecycleObserver {

  private static final long MILLISECONDS_PER_MONTH = 30L * 24 * 60 * 60 * 1000;
  private final ZoomMeetingRepository repository;
  private final MutableLiveData<Long> zoomMeetingId;
  private final LiveData<ZoomMeeting> zoomMeeting;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  @Inject
  ZoomMeetingViewModel(@ApplicationContext Context context, ZoomMeetingRepository repository) {
    this.repository = repository;
    this.zoomMeetingId = new MutableLiveData<>();
    this.zoomMeeting = new MutableLiveData<>();
    this.throwable = new MutableLiveData<>();
    this.pending = new CompositeDisposable();
//    connect();
    fetchMeetings();
//    fetchDetails(821_3179_6284L);
  }

  private void connect() {
    repository.authenticate()
        .subscribe(
            (auth) -> Log.d(getClass().getSimpleName(), auth.toString()),
            this::postThrowable,
            pending
        );
  }

  public void fetchMeetings() {
    Date to = new Date();
    Date from = new Date(to.getTime() - MILLISECONDS_PER_MONTH);
    repository.observeMeetings(from, to)
        .subscribe(
            () ->
                Log.d(getClass().getSimpleName(), "Meetings Recorded"),
            this::postThrowable,
            pending
        );
  }

  public void fetchDetails(long meetingId) {
    repository.fetchMeeting(meetingId)
        .subscribe();
  }

  public LiveData<Long> getZoomMeetingId() {
    return zoomMeetingId;
  }

  public LiveData<ZoomMeeting> getZoomMeeting() {
    return zoomMeeting;
  }

  public LiveData<List<ZoomMeeting>> getZoomMeetings() {
    return repository.get();
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  @Override
  public void onStop(@NotNull LifecycleOwner owner) {
    DefaultLifecycleObserver.super.onStop(owner);
    pending.clear();
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
  }
}
