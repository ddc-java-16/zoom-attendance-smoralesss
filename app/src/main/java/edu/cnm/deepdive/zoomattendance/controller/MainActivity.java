package edu.cnm.deepdive.zoomattendance.controller;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }


//  private void joinMeeting(Context context, String meetingNumber, String password) {
//    MeetingService meetingService = ZoomSDK.getInstance().getMeetingService();
//    JoinMeetingOptions options = new JoinMeetingOptions();
//    JoinMeetingParams params = new JoinMeetingParams();
//    params.displayName = ""; // TODO: Enter your name
//    params.meetingNo = meetingNumber;
//    params.password = password;
//    meetingService.joinMeetingWithParams(context, params, options);
//  }
}
