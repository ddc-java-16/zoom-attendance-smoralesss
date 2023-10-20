package edu.cnm.deepdive.zoomattendance.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.time.Instant;

@Entity(
    tableName = "zoom_meeting",
    foreignKeys = {
        @ForeignKey(
            entity = Student.class,
            parentColumns = "student_id", childColumns = "student_id", onDelete = ForeignKey.CASCADE
        )
    }
)
public class ZoomMeeting {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "zoom_meeting_id")
  private long id;


  @ColumnInfo(name = "student_id", index = true)
  private long studentId;

  @NonNull
  private Instant created = Instant.MIN;

  @NonNull
  private Instant started = Instant.MIN;

  private long duration;

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }

  public void setCreated(@NonNull Instant created) {
    this.created = created;
  }

  @NonNull
  public Instant getStarted() {
    return started;
  }

  public void setStarted(@NonNull Instant started) {
    this.started = started;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


}
