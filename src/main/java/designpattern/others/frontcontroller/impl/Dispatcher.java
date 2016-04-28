package designpattern.others.frontcontroller.impl;

/**
 * Created by kimi on 4/28/16.
 */
public class Dispatcher {
    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("STUDENT")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}
