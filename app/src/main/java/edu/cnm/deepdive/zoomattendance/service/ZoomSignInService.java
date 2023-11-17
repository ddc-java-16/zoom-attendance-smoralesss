package edu.cnm.deepdive.zoomattendance.service;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ZoomSignInService {

  private static final String BEARER_TOKEN_FORMAT = "Bearer %s";



  @Inject
  ZoomSignInService(@ApplicationContext Context context) {

  }



//  private final ZoomSignInClient client;
}



