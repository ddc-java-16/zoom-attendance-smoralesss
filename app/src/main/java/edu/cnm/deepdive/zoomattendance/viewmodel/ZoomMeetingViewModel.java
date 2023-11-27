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
import edu.cnm.deepdive.zoomattendance.R;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import edu.cnm.deepdive.zoomattendance.service.PreferencesRepository;
import edu.cnm.deepdive.zoomattendance.service.ZoomMeetingRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

@HiltViewModel
public class ZoomMeetingViewModel extends ViewModel implements DefaultLifecycleObserver {

  private static final long MILLISECONDS_PER_DAY = 24L * 60 * 60 * 1000;
  private final ZoomMeetingRepository meetingRepository;
  private final PreferencesRepository preferencesRepository;
  private final MutableLiveData<Long> zoomMeetingId;
  private final LiveData<ZoomMeeting> zoomMeeting;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final String queryDayKey;
  private final int queryDayDefault;

  @Inject
  ZoomMeetingViewModel(@ApplicationContext Context context, ZoomMeetingRepository meetingRepository,
      PreferencesRepository preferencesRepository) {
    this.meetingRepository = meetingRepository;
    this.preferencesRepository = preferencesRepository;
    this.zoomMeetingId = new MutableLiveData<>();
    this.zoomMeeting = new MutableLiveData<>();
    this.throwable = new MutableLiveData<>();
    this.pending = new CompositeDisposable();
    queryDayKey = context.getString(R.string.query_day_key);
    queryDayDefault = context.getResources().getInteger(R.integer.default_day_query);
//    connect();
    fetchMeetings();
//    fetchDetails(821_3179_6284L);
  }

  private void connect() {
    meetingRepository.authenticate()
        .subscribe(
            (auth) -> Log.d(getClass().getSimpleName(), auth.toString()),
            this::postThrowable,
            pending
        );
  }

  public void fetchMeetings() {
    Date to = new Date();
    Date from = new Date(to.getTime() - preferencesRepository.get(queryDayKey, queryDayDefault) * MILLISECONDS_PER_DAY);
    meetingRepository.observeMeetings(from, to)
        .subscribe(
            () ->
                Log.d(getClass().getSimpleName(), "Meetings Recorded"),
            this::postThrowable,
            pending
        );
  }

  public void fetchDetails(long meetingId) {
    meetingRepository.fetchMeeting(meetingId)
        .subscribe();
  }

  public LiveData<Long> getZoomMeetingId() {
    return zoomMeetingId;
  }

  public LiveData<ZoomMeeting> getZoomMeeting() {
    return zoomMeeting;
  }

  public LiveData<List<ZoomMeeting>> getZoomMeetings() {
    return meetingRepository.get();
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
