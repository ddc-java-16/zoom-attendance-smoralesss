package edu.cnm.deepdive.zoomattendance.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.zoomattendance.model.dao.StudentDao;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import java.util.List;
import javax.inject.Inject;

public class StudentRepository {

  private final StudentDao studentDao;
@Inject
  public StudentRepository(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public LiveData<List<Student>> search (String fragment) {
    return studentDao.search("%" + fragment + "%");
  }
}
