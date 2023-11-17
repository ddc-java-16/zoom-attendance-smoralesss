package edu.cnm.deepdive.zoomattendance.service;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Random;

public class CodeChallengeHelper {



  public static String createCodeVerifier() {

    Random rng = new SecureRandom();

    byte[] code = new byte[32];

    rng.nextBytes(code);

    return Base64.encodeToString(code, Base64.URL_SAFE | Base64.NO_WRAP | Base64.NO_PADDING);

  }

  public static String getCodeChallenge(String verifier) {

    byte[] bytes = verifier.getBytes(StandardCharsets.UTF_8);

    MessageDigest digest = null;
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

    digest.update(bytes);

    byte[] digestBytes = digest.digest();

    return Base64.encodeToString(digestBytes, Base64.URL_SAFE | Base64.NO_WRAP | Base64.NO_PADDING);
  }
}
