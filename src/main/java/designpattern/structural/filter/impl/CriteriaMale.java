package designpattern.structural.filter.impl;

import designpattern.structural.filter.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimi on 4/27/16.
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
