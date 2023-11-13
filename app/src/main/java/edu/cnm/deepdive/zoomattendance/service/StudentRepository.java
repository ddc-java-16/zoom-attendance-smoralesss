package edu.cnm.deepdive.zoomattendance.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.zoomattendance.model.AttendanceAggregate;
import edu.cnm.deepdive.zoomattendance.model.dao.StudentDao;
import edu.cnm.deepdive.zoomattendance.model.entity.Student;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.Instant;
import java.util.List;
import javax.inject.Inject;

public class StudentRepository {

  private final StudentDao studentDao;

  @Inject
  public StudentRepository(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public LiveData<List<Student>> search(String fragment) {
    return studentDao.search("%" + fragment + "%");
  }

  public LiveData<List<Student>> get() {
    return studentDao.get();
  }

  public LiveData<Student> get(long id) {
    return studentDao.select(id);
  }

  public LiveData<List<AttendanceAggregate>> getAggregate(long studentId, Instant start, Instant end) {
    return studentDao
        .getAggregate(studentId, start, end);
  }

  public Single<Student> insert(Student student) {
    return studentDao
        .insert(student)
        .map(id -> {
          student.setId(id);
          return student;
        })
        .subscribeOn(Schedulers.io());
  }

  public Completable delete(Student student) {
    return studentDao
        .delete(student)
        .ignoreElement()
        .subscribeOn(Schedulers.io());
  }

}
