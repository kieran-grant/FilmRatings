package reference.domain;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Person current = (Person) obj;

        if (this.getName().equals(current.getName())) {
            return true;
        } else {
            return false;
        }
    }
}
