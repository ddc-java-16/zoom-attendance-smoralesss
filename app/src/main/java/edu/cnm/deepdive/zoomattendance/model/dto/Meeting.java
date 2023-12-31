package edu.cnm.deepdive.zoomattendance.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.UUID;

public class Meeting {

  @Expose
  private final long id = 0;
  @Expose
  private final String uuid = null;
  @Expose
  @SerializedName("created_at")
  private final Date created = null;
  @Expose
  @SerializedName("start_time")
  private final Date start = null;
  @Expose
  private final int duration = 0;
  @Expose
  private final String topic = null;

  public long getId() {
    return id;
  }

  public String getUuid() {
    return uuid;
  }

  public Date getCreated() {
    return created;
  }

  public Date getStart() {
    return start;
  }

  public int getDuration() {
    return duration;
  }

  public String getTopic() {
    return topic;
  }
}
