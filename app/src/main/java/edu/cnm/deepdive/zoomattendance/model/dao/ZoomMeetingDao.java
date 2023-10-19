package edu.cnm.deepdive.zoomattendance.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

/**
 * Provides CRUD operations on {@link ZoomMeeting} entity instances. {@code INSERT}, {@code UPDATE}, and
 * {@code DELETE} operations are implemented as ReactiveX {@link Single} tasks, which execute on
 * subscription; some {@code SELECT} tasks are implemented using {@link LiveData} queries, which
 * execute on observation, or (if already being observed) on Room-based updates to the underlying
 * tables; one {@code SELECT} ({@link #select(String)}) is implemented as a ReactiveX {@link Maybe}
 * task, to allow for the appropriate handling of an empty query result.
 */
@SuppressWarnings("unused")
@Dao
public interface ZoomMeetingDao {

  @Insert
  Single<Long> insert(ZoomMeeting zoomMeeting);


  @Query("SELECT * FROM zoom_meeting WHERE zoom_meeting_id = :id")
  LiveData<ZoomMeeting> select(long id);

}
