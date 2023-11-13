package edu.cnm.deepdive.zoomattendance.model;

import androidx.room.Embedded;
import androidx.room.Relation;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class AttendanceAggregate {

  private static final TemporalAdjuster HOUR_ADJUSTER = (temporal) -> ChronoField.MINUTE_OF_HOUR.adjustInto(ChronoField.SECOND_OF_MINUTE.adjustInto(ChronoField.NANO_OF_SECOND.adjustInto(temporal, 0), 0), 0);
  private static final TemporalAdjuster DAY_ADJUSTER = (temporal) -> ChronoField.HOUR_OF_DAY.adjustInto(temporal.with(HOUR_ADJUSTER), 0);
  private static final TemporalAdjuster WEEK_ADJUSTER = (temporal) -> ChronoField.DAY_OF_WEEK.adjustInto(temporal.with(DAY_ADJUSTER), 0);

  @Embedded
  private Student student;
  @Relation(parentColumn = "student_id", entityColumn = "student_id")
  private List<ZoomMeeting> zoomMeetings;

  public SortedMap<OffsetDateTime, Long> getAggregates(ChronoUnit unit) {
    Map<OffsetDateTime, Long> aggregates = new TreeMap<>();
    Duration duration = Duration.of(1, unit);

    List<ZoomMeeting> zoomMeetings = getZoomMeetings();

    zoomMeetings.stream()
        .flatMap(meeting -> {
          TemporalAdjuster adjuster = switch (unit) {
            case HOURS -> HOUR_ADJUSTER;
            case DAYS -> DAY_ADJUSTER;
            case WEEKS -> WEEK_ADJUSTER;
            default -> throw new IllegalArgumentException();
          };
          int bucketSize = switch (unit) {
            case HOURS
          };
          LocalDateTime baseline = LocalDateTime.ofInstant(meeting.getStarted(), ZoneId.systemDefault()).with(adjuster);
          return IntStream.iterate(0, (value) -> value + 1)
              .mapToObj(value ->)
        })
        .forEach(entry -> {
          OffsetDateTime start = entry.getKey();
          OffsetDateTime end = entry.getValue();

          while (start.isBefore(end)) {
            OffsetDateTime bucketEnd = start.plus(duration);

            aggregates.put(start, aggregates.getOrDefault(start, 0L) + 1);

            start = bucketEnd;
          }
        });

    return new TreeMap<>(aggregates);
    // TODO: 11/13/23
    //  -Create a stream of zoomMeeting using our zoomMeetings List as a source of the stream
    //  -Map each of the zoomMeeting into an array of start & end instant
    //  -For each aggregation, split it accordingly into time buckets
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
