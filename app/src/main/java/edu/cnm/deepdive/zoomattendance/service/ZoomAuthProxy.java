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

public interface ZoomAuthProxy {



  @FormUrlEncoded
  @POST("oauth/token")
  @Headers("Content-Type: application/x-www-form-urlencoded")
  Single<Authentication> authenticate(@Header("Authorization") String authorization, @Field("account_id") String accountId, @Field("grant_type") String grantType);

}



