package edu.cnm.deepdive.zoomattendance.service;

import edu.cnm.deepdive.zoomattendance.model.dto.MeetingListResponse;
import edu.cnm.deepdive.zoomattendance.model.dto.MeetingParticipantsResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ZoomApiProxy {

  @GET("users/{userId}/meetings")
  Single<MeetingListResponse> listMeetings(@Header("Authorization") String bearerToken, @Path("userId")String userId, @Query("next_page_token") String nextPageToken, @Query("from") String from, @Query("to") String to);

  @GET("past_meetings/{meetingId}/participants")
  Single<MeetingParticipantsResponse> listParticipants(@Header("Authorization") String bearerToken, @Path("meetingId")String meetingId, @Query("next_page_token") String nextPageToken);


}
