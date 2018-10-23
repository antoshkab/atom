package ru.atom.cache;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * What about Map?
 */
public class ContactListCache extends AbstractCache<Person, List<? extends Person>> {

    private Map<Person, List<? extends Person>> personMap;

    public ContactListCache(int capacity) {
        super(capacity);
        personMap = new HashMap<>(capacity);
    }

    @Override
    public boolean put(Person person, List<? extends Person> people) {
        if (personMap.containsKey(person)) return false;
        if (personMap.size() == capacity) removeAny();
        personMap.put(person, people);
        return true;
    }

    @Override
    public List<? extends Person> get(Person person) {
        return personMap.get(person);
    }

    @Override
    public int getSize() {
        return personMap.size();
    }

    private boolean removeAny() {
        personMap.remove(personMap.keySet().stream().findFirst().get());
        return true;
    }
}
