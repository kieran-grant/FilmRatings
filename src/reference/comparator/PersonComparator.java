package reference.comparator;
import reference.domain.Person;
import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if (peopleIdentities.get(o1) == null || peopleIdentities.get(o2) == null)
            return 0;

        return peopleIdentities.get(o2) - peopleIdentities.get(o1);
    }
}
