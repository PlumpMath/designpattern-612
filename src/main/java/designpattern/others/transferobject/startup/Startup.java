package designpattern.others.transferobject.startup;

import designpattern.others.transferobject.impl.StudentBO;
import designpattern.others.transferobject.model.StudentVO;

/**
 * Created by kimi on 4/28/16.
 */
public class Startup {
    public static void main(String[] args) {
        StudentBO studentBusinessObject = new StudentBO();

        //print all students
        for (StudentVO student : studentBusinessObject.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //update student
        StudentVO student = studentBusinessObject.getAllStudents().get(0);
        student.setName("Michael");
        studentBusinessObject.updateStudent(student);

        //get the student
        student = studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}
