package edu.cnm.deepdive.zoomattendance.model;

import androidx.room.Embedded;
import androidx.room.Relation;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class AttendanceAggregate {

  @Embedded
  private Student student;
  @Relation(parentColumn = "student_id", entityColumn = "student_id")
  private List<ZoomMeeting> zoomMeetings;

  public SortedMap<OffsetDateTime, Long> getAggregates(ChronoUnit unit) {
    Map<OffsetDateTime, Long> aggregates = new TreeMap<>();
    Duration duration = Duration.of(1, unit);

    // TODO: 11/13/23
    //  -Create a stream of zoomMeeting using our zoomMeetings List as a source of the stream
    //  -Map each of the zoomMeeting into an array of start & end instant
    //  -For each aggretation, split it accordingly into time buckets
    //  -Return the map
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public List<ZoomMeeting> getZoomMeetings() {
    return zoomMeetings;
  }

  public void setZoomMeetings(
      List<ZoomMeeting> zoomMeetings) {
    this.zoomMeetings = zoomMeetings;
  }
}
