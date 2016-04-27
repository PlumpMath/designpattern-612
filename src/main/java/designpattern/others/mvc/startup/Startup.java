package designpattern.others.mvc.startup;

import designpattern.others.mvc.controller.StudentController;
import designpattern.others.mvc.model.Student;
import designpattern.others.mvc.view.StudentView;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }

    public static void main(String[] args) {
        Student model = retriveStudentFromDatabase();
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //update model data
        controller.setStudentName("John");

        controller.updateView();
    }
}
