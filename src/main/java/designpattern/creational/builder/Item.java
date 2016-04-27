package designpattern.creational.builder;

/**
 * Created by kimi on 4/26/16.
 */
public interface Item {
    String name();

    Packing packing();

    float price();
}
