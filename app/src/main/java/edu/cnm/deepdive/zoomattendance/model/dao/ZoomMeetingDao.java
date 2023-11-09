package edu.cnm.deepdive.zoomattendance.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import io.reactivex.rxjava3.core.Single;
import java.util.List;


@SuppressWarnings("unused")
@Dao
public interface ZoomMeetingDao {

  @Insert
  Single<Long> insert(ZoomMeeting zoomMeeting);

  @Delete
  Single<Integer> delete(ZoomMeeting zoomMeeting);

  @Query("SELECT * FROM zoom_meeting WHERE zoom_meeting_id = :id")
  LiveData<ZoomMeeting> select(long id);

  @Query("SELECT * FROM zoom_meeting WHERE student_id = :studentId ORDER BY started DESC")
  LiveData<List<ZoomMeeting>> selectByStudentId(long studentId);

  @Query("SELECT * FROM zoom_meeting ORDER BY student_id")
  LiveData<List<ZoomMeeting>> get();
}
