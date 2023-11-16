package edu.cnm.deepdive.zoomattendance.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;

public class MeetingParticipantsResponse {

  @Expose
  @SerializedName("next_page_token")
  private final String nextPageToken = null;
  @Expose
  @SerializedName("page_count")
  private final int pageCount = 0;
  @Expose
  @SerializedName("page_number")
  private final int pageNumber = 0;
  @Expose
  private final List<Participant> participants = new LinkedList<>();

  public String getNextPageToken() {
    return nextPageToken;
  }

  public int getPageCount() {
    return pageCount;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public List<Participant> getParticipants() {
    return participants;
  }
}
