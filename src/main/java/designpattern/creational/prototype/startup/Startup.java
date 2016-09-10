package designpattern.creational.prototype.startup;

import designpattern.creational.prototype.Shape;
import designpattern.creational.prototype.impl.ShapeCache;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape1 = (Shape) ShapeCache.getShape("1");
        System.out.println(clonedShape.equals(clonedShape1));

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

        Shape clonedShape4 = (Shape) ShapeCache.getShape("4");
        System.out.println(clonedShape4 == null);
    }
}
