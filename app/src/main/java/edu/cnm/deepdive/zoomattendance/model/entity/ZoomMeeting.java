package edu.cnm.deepdive.zoomattendance.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;

@Entity(
    tableName = "zoom_meeting",
    foreignKeys = {
        @ForeignKey(
            entity = Student.class,
            parentColumns = "student_id", childColumns = "student_id", onDelete = ForeignKey.SET_NULL
        )
    },
    indices = {
        @Index(value = {"uuid", "student_id"}, unique = true),
        @Index(value = {"uuid", "created"}, unique = true)
    }
)
public class ZoomMeeting {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "zoom_meeting_id")
  private long id;

  @ColumnInfo(index = true)
  private String uuid;

  @ColumnInfo(name = "student_id", index = true)
  private Long studentId;

  @NonNull
  private Instant created = Instant.MIN;

  @NonNull
  private Instant started = Instant.MIN;

  private long duration;

  private String topic;

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }
}
