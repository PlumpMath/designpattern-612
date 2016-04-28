package designpattern.others.dataaccessobject;

import designpattern.others.dataaccessobject.model.Student;

import java.util.List;

/**
 * Created by kimi on 4/28/16.
 */
public interface StudentDao {
    public List<Student> getAllStudents();

    public Student getStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
