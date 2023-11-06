package edu.cnm.deepdive.zoomattendance.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.zoomattendance.model.dao.StudentDao;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import io.reactivex.rxjava3.core.Single;
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

  private Single<Student> insert(Student student) {
  return studentDao
      .insert(student);
  }
}
