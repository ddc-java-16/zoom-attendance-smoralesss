package edu.cnm.deepdive.zoomattendance.model;

import androidx.room.Embedded;
import androidx.room.Relation;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import edu.cnm.deepdive.zoomattendance.model.entity.ZoomMeeting;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
  private static final TemporalAdjuster WEEK_ADJUSTER = (temporal) -> ChronoField.DAY_OF_WEEK.adjustInto(temporal.with(DAY_ADJUSTER), 1);
  private static final long SECONDS_PER_HOUR = Duration.ofHours(1).getSeconds();
  private static final long SECONDS_PER_DAY = Duration.ofDays(1).getSeconds();
  private static final long SECONDS_PER_WEEK = Duration.ofDays(7).getSeconds();

  @Embedded
  private Student student;
  @Relation(parentColumn = "student_id", entityColumn = "student_id")
  private List<ZoomMeeting> zoomMeetings;

  public SortedMap<LocalDateTime, Long> getAggregates(ChronoUnit unit) {
    SortedMap<LocalDateTime, Long> aggregates = new TreeMap<>();


    List<ZoomMeeting> zoomMeetings = getZoomMeetings();

    zoomMeetings.stream()
        .flatMap(meeting -> {
          TemporalAdjuster adjuster = switch (unit) {
            case HOURS -> HOUR_ADJUSTER;
            case DAYS -> DAY_ADJUSTER;
            case WEEKS -> WEEK_ADJUSTER;
            default -> throw new IllegalArgumentException();
          };
          long bucketSize = switch (unit) {
            case HOURS -> SECONDS_PER_HOUR;
            case DAYS -> SECONDS_PER_DAY;
            case WEEKS -> SECONDS_PER_WEEK;
            default -> 0;
          };
          LocalDateTime baseline = LocalDateTime.ofInstant(meeting.getStarted(), ZoneId.systemDefault()).with(adjuster);
          return IntStream.iterate(0, (value) -> value + 1)
              .mapToObj(value -> baseline.plusSeconds(value * bucketSize))
              .map((start) -> {
                Instant startingInstant = start.toInstant(ZoneId.systemDefault().getRules()
                    .getOffset(start));
                ZoomMeeting slice = new ZoomMeeting();
                slice.setStarted(start.toInstant(ZoneId.systemDefault().getRules().getOffset(start)));
                long duration = (meeting.getStarted().compareTo(startingInstant) > 0)
                    ? startingInstant.plusSeconds(bucketSize).getEpochSecond() - meeting.getStarted().getEpochSecond()
                    : bucketSize;
                if (startingInstant.plusSeconds(bucketSize).compareTo(meeting.getStarted().plusSeconds(meeting.getDuration())) > 0) {
                  duration -= startingInstant.plusSeconds(bucketSize).getEpochSecond() - meeting.getStarted().plusSeconds(meeting.getDuration()).getEpochSecond();
                }
                slice.setDuration(duration);
                return slice;
              });
        })
        .forEach(meeting -> {
          LocalDateTime key = LocalDateTime.ofInstant(meeting.getStarted(), ZoneId.systemDefault());
          aggregates.put(key, aggregates.getOrDefault(key, 0L) + meeting.getDuration());

        });
    return aggregates;

//    return new TreeMap<>(aggregates);

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
