package edu.cnm.deepdive.zoomattendance.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Participant {

  @Expose
  private final String id = null;
  @Expose
  private final String name = null;
  @Expose
  @SerializedName("join_time")
  private final Date joined = null;
  @Expose
  private final int duration = 0;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getJoined() {
    return joined;
  }

  public int getDuration() {
    return duration;
  }
}
