package designpattern.behavioral.iterator.impl;

import designpattern.behavioral.iterator.Container;
import designpattern.behavioral.iterator.Iterator;

/**
 * Created by kimi on 4/27/16.
 */
public class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora", "Hello", "World", "Kimi"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
