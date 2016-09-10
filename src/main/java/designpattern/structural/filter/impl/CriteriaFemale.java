package designpattern.structural.filter.impl;

import designpattern.structural.filter.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 4/27/16.
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
