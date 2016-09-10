package designpattern.behavioral.command.impl;

import designpattern.behavioral.command.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 4/27/16.
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
