package edu.cnm.deepdive.zoomattendance.service;

import edu.cnm.deepdive.zoomattendance.model.dao.ZoomMeetingDao;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ZoomMeetingRepository {

  private final ZoomMeetingDao zoomMeetingDao;

  @Inject
  public ZoomMeetingRepository(ZoomMeetingDao zoomMeetingDao) {this.zoomMeetingDao = zoomMeetingDao;}
}
