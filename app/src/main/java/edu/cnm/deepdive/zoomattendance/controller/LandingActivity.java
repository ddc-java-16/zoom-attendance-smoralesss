package edu.cnm.deepdive.zoomattendance.controller;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.zoomattendance.R;
import edu.cnm.deepdive.zoomattendance.adapter.MeetingAdapter;
import edu.cnm.deepdive.zoomattendance.databinding.ActivityLandingBinding;
import edu.cnm.deepdive.zoomattendance.service.CodeChallengeHelper;
import edu.cnm.deepdive.zoomattendance.service.ZoomMeetingRepository;
import edu.cnm.deepdive.zoomattendance.viewmodel.ZoomMeetingViewModel;

@AndroidEntryPoint
public class LandingActivity extends AppCompatActivity {

  private static final String ZOOM_OAUTH_URI = "https://zoom.us/oauth/authorize";
  private ZoomMeetingViewModel viewModel;
  private ActivityLandingBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLandingBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
//    openLogin();
    viewModel = new ViewModelProvider(this)
        .get(ZoomMeetingViewModel.class);
    viewModel.getZoomMeetings()
        .observe(this,
            (meetings) -> binding.meetings.setAdapter(new MeetingAdapter(this, meetings)));
  }

  private void openLogin() {
    Uri uri = Uri.parse(ZOOM_OAUTH_URI)
        .buildUpon()
        .appendQueryParameter("code_challenge",
            CodeChallengeHelper.getCodeChallenge(CodeChallengeHelper.createCodeVerifier()))
        .appendQueryParameter("code_challenge_method", "S256")
        .build();
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(intent);
  }

  private void initializeSdk() {
    //ZoomSDK
  }
}