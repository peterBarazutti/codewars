package four_kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WeAreFamily {

    List<Person> family;

    public WeAreFamily() {
        family = new ArrayList<>();
    }

    private class Person {
        String name;
        GENDER gender;
        Person parent1;
        Person parent2;
        List<Person> children = new ArrayList<>();
        List<Person> connectedTo = new ArrayList<>();

        public Person() {
            name = null;
            gender = GENDER.UNKNOWN;
            children = new ArrayList<>();
            connectedTo = new ArrayList<>();
        }

        public void addObserver(Person person) {
            connectedTo.add(person);
        }

        public void removeObserver(Person person) {
            connectedTo.remove(person);
        }

        public void notifyAllObservers() {
            for (Person person : connectedTo) {
                person.update();
            }
        }

        private void update() {
            for (Person child : this.children) {
                child.updateOtherParentsGender();
            }
        }

        private void updateOtherParentsGender() {
            if (parent1.gender != GENDER.UNKNOWN) {
                parent2.gender = GENDER.MALE.reverse(parent1);
            } else if (parent2.gender != GENDER.UNKNOWN) {
                parent1.gender = GENDER.MALE.reverse((parent2));
            }
        }

    }

    private enum GENDER {
        MALE,
        FEMALE,
        UNKNOWN;

        GENDER reverse(Person person) {
            if (person.gender == GENDER.FEMALE) return GENDER.MALE;
            else if (person.gender == GENDER.MALE) return GENDER.FEMALE;
            else return GENDER.UNKNOWN;
        }
    }

    public boolean male(String name) {
        Person person = new Person();
        try {
            person = family.stream().filter(p -> p.name.equals(name)).findAny().get();
            if (person.gender == GENDER.FEMALE) {
                return false;
            }
        } catch (Exception e) {
            person.name = name;
            family.add(person);
        } finally {
            person.gender = GENDER.MALE;
            person.notifyAllObservers();
        }
        return true;
    }

    public boolean isMale(String name) {
        return false;
    }

    public boolean female(String name) {
        Person person;
        try {
            person = family.stream().filter(p -> p.name.equals(name)).findAny().get();
            if (person.gender == GENDER.MALE) {
                return false;
            }
        } catch (Exception e) {
            person = new Person();
            person.name = name;
            family.add(person);
        }
        person.gender = GENDER.FEMALE;
        person.notifyAllObservers();
        return true;
    }

    public boolean isFemale(String name) {
        return false;
    }

    public boolean setParentOf(String childName, String parentName) {
        Person child;
        Person parent = new Person();
        parent.name = parentName;
        try {
            child = family.stream().filter(p -> p.name.equals(childName)).findAny().get();
        } catch (NoSuchElementException e) {
            child = new Person();
            child.name = childName;
            family.add(child);
        }
        if (child.parent1 == null) {
            child.parent1 = parent;
        }
        else if (child.parent1 != null
                && child.parent2== null) {
            child.parent2= parent;
        }
        else return false;
        family.add(parent);
        parent.children.add(child);
        child.update();
        return true;
    }

    public List<String> getParentsOf(String name) {
        return new ArrayList<String>();
    }

    public List<String> getChildrenOf(String name) {
        return new ArrayList<String>();
    }
}
