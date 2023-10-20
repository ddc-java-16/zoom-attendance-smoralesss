package edu.cnm.deepdive.zoomattendance.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "student"
)
public class Student {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "student_id")
  private long id;

  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
