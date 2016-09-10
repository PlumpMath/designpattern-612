package designpattern.behavioral.command.startup;

import designpattern.behavioral.command.Order;
import designpattern.behavioral.command.impl.Broker;
import designpattern.behavioral.command.impl.BuyStock;
import designpattern.behavioral.command.impl.SellStock;
import designpattern.behavioral.command.impl.Stock;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        Stock abcStock = new Stock();
        Order buyStockOrder = new BuyStock(abcStock);
        Order sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
