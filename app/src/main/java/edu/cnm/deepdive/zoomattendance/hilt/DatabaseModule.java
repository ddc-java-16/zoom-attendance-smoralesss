package edu.cnm.deepdive.zoomattendance.hilt;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.zoomattendance.model.dao.StudentDao;
import edu.cnm.deepdive.zoomattendance.model.dao.UserDao;
import edu.cnm.deepdive.zoomattendance.model.dao.ZoomMeetingDao;
import edu.cnm.deepdive.zoomattendance.service.ZoomAttendanceDatabase;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link ZoomAttendanceDatabase} and {@link UserDao}.
 */
@InstallIn(SingletonComponent.class)
@Module
public final class DatabaseModule {

  DatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  @Provides
  @Singleton
  ZoomAttendanceDatabase provideLocalDatabase(@ApplicationContext Context context) {
    return Room
        .databaseBuilder(context, ZoomAttendanceDatabase.class, ZoomAttendanceDatabase.NAME)
        .addCallback(new ZoomAttendanceDatabase.Callback())
        .build();
  }

  @Provides
  @Singleton
  UserDao provideUserDao(ZoomAttendanceDatabase database) {
    return database.getUserDao();
  }

  @Provides
  @Singleton
  StudentDao providesStudentDao(ZoomAttendanceDatabase database) {
    return database.getStudentDao();
  }

  @Provides
  @Singleton
  ZoomMeetingDao providesZoomMeetingDao(ZoomAttendanceDatabase database) {
    return database.getZoomMeetingDao();
  }
  // TODO Add additional methods so satisfy dependencies on other DAO interface implementations.

}
