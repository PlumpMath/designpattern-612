package designpattern.structural.filter;

import designpattern.structural.filter.impl.Person;

import java.util.List;

/**
 * Created by kimi on 4/27/16.
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
