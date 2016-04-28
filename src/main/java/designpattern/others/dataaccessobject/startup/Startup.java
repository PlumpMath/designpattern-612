package designpattern.others.dataaccessobject.startup;

import designpattern.others.dataaccessobject.StudentDao;
import designpattern.others.dataaccessobject.impl.StudentDaoImpl;
import designpattern.others.dataaccessobject.model.Student;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        //print all students
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }


        //update student
        Student student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);

        //get the student
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}
