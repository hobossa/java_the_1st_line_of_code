package Pet;

public class Cat implements Pet {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        if (! (obj instanceof Cat)) {
            return  false;
        }
        Cat c = (Cat)obj;
        if (name.equals(c.name) && age == c.age) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "This is a cat, name: " + name + ". age: " + age;
    }
}
