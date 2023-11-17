package edu.cnm.deepdive.zoomattendance.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Authentication {

  @Expose
  @SerializedName("access_token")
  private final String token = null;

  @Expose
  @SerializedName("token_type")
  private final String tokenType = null;

  private final Date created = new Date();

  @Expose
  @SerializedName("expires_in")
  private final int duration = 0;

  @Expose
  private final String scope = null;

  public String getToken() {
    return token;
  }

  public String getTokenType() {
    return tokenType;
  }

  public Date getCreated() {
    return created;
  }

  public int getDuration() {
    return duration;
  }

  public String getScope() {
    return scope;
  }
}
