package edu.cnm.deepdive.zoomattendance.service;

import edu.cnm.deepdive.zoomattendance.model.dto.Authentication;
import edu.cnm.deepdive.zoomattendance.model.dto.MeetingListResponse;
import edu.cnm.deepdive.zoomattendance.model.dto.MeetingParticipantsResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ZoomApiProxy {


  @GET("users/me/meetings")
  Single<MeetingListResponse> listMeetings(@Header("Authorization") String bearerToken, @Query("next_page_token") String nextPageToken, @Query("from") String from, @Query("to") String to, @Query("page_size") int pageSize);

  @GET("past_meetings/{meetingId}/participants")
  Single<MeetingParticipantsResponse> listParticipants(@Header("Authorization") String bearerToken, @Path("meetingId")String meetingId, @Query("next_page_token") String nextPageToken);


}



