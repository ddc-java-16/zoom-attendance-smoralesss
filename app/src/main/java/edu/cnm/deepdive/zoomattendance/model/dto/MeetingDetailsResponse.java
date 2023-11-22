package edu.cnm.deepdive.zoomattendance.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;

public class MeetingDetailsResponse {

  @Expose
  @SerializedName("host_id")
  private final String hostId = null;
  @Expose
  private final long id = 0;
  @Expose
  private final String uuid = null;
  @Expose
  private final List<Occurrence> occurrences = new LinkedList<>();

  public String getHostId() {
    return hostId;
  }

  public long getId() {
    return id;
  }

  public String getUuid() {
    return uuid;
  }

  public List<Occurrence> getOccurrences() {
    return occurrences;
  }

  public static class Occurrence {

    @Expose
    private final int duration = 0;
    @Expose
    @SerializedName("occurrence_id")
    private final String occurrenceId = null;

    public int getDuration() {
      return duration;
    }

    public String getOccurrenceId() {
      return occurrenceId;
    }
  }

}
