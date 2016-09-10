package designpattern.behavioral.command.impl;

import designpattern.behavioral.command.Order;

/**
 * Created by kimi on 4/27/16.
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
