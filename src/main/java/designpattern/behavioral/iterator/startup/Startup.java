package designpattern.behavioral.iterator.startup;

import designpattern.behavioral.iterator.Iterator;
import designpattern.behavioral.iterator.impl.NameRepository;

/**
 * Created by kimi on 4/27/16.
 */
public class Startup {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
