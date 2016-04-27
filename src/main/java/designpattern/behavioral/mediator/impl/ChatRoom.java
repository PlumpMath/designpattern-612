package designpattern.behavioral.mediator.impl;

import java.util.Date;

/**
 * Created by kimi on 4/27/16.
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
