package designpattern.behavioral.command.impl;

import designpattern.behavioral.command.Order;

/**
 * Created by kimi on 4/27/16.
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
