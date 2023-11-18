package edu.cnm.deepdive.zoomattendance.model.dto;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
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

  public Date expiration() {
    //noinspection PointlessArithmeticExpression
    return new Date(created.getTime() + duration * 1000);
  }

  @SuppressLint("DefaultLocale")
  @NonNull
  @Override
  public String toString() {
    return String.format("%1$s[token=%2$s, tokentype=%3$s, scope=%4$s, created=%5$s, duration=%6$d]", getClass().getSimpleName(), token, tokenType, scope, created, duration);

  }
}
