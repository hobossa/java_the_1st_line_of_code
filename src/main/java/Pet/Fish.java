package Pet;

public class Fish implements Pet {
    private String name;
    private int age;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Fish)) {
            return  false;
        }
        Fish f = (Fish)obj;
        if (name.equals(f.name) && age == f.age) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "This is a piece of fish, name: " + name + ". age: " + age;
    }
}
