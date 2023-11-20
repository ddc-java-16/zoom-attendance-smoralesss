package edu.cnm.deepdive.zoomattendance.hilt;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.zoomattendance.service.ZoomApiProxy;
import edu.cnm.deepdive.zoomattendance.service.ZoomAuthProxy;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public final class ZoomModule {

  @Singleton
  @Provides
  ZoomAuthProxy buildAuthProxy(@ApplicationContext Context context) {
    Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://zoom.us/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build();
    return retrofit.create(ZoomAuthProxy.class);
  }

  @Singleton
  @Provides
  ZoomApiProxy buildApiProxy(@ApplicationContext Context context) {
    Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .setDateFormat("yyyy-MM-dd")
        .create();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.zoom.us/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build();
    return retrofit.create(ZoomApiProxy.class);
  }
}
