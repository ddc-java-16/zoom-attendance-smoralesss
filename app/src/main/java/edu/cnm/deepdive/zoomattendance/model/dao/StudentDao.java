package edu.cnm.deepdive.zoomattendance.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.zoomattendance.model.AttendanceAggregate;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import io.reactivex.rxjava3.core.Single;
import java.time.Instant;
import java.util.List;

@Dao
public interface StudentDao {

  @Insert
  Single<Long> insert(Student student);

  @Delete
  Single<Integer> delete(Student student);

  @Query("SELECT * FROM student WHERE student_id = :id")
  LiveData<Student> select(long id);

  @Query("SELECT * FROM student WHERE student_id LIKE :pattern ORDER BY name")
  LiveData<List<Student>> search(String pattern);

  @Query("SELECT * FROM student ORDER BY name")
  LiveData<List<Student>> get();

  @Query("SELECT DISTINCT * FROM student AS s JOIN zoom_meeting AS z ON z.student_id = s.student_id WHERE s.student_id = :studentId AND z.started <= :end AND z.started + z.duration >= :start ORDER BY z.started ASC")
  LiveData<List<AttendanceAggregate>> getAggregate(long studentId, Instant start, Instant end);

}
