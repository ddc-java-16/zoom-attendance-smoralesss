package edu.cnm.deepdive.zoomattendance.controller;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.zoomattendance.R;
import edu.cnm.deepdive.zoomattendance.service.CodeChallengeHelper;

public class LandingActivity extends AppCompatActivity {

  private static final String ZOOM_OAUTH_URI = "https://zoom.us/oauth/authorize";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_landing);
    openLogin();
  }

  private void openLogin() {
    Uri uri = Uri.parse(ZOOM_OAUTH_URI)
        .buildUpon()
        .appendQueryParameter("code_challenge", CodeChallengeHelper.getCodeChallenge(CodeChallengeHelper.createCodeVerifier()))
        .appendQueryParameter("code_challenge_method", "S256")
        .build();
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(intent);
  }

  private void initializeSdk(){
    //ZoomSDK
  }
}