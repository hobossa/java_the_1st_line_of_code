package Pet;

public class Dog implements Pet {
    private String name;
    private int age;

    public Dog(String name, int age) {
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
        if (! (obj instanceof Dog)) {
            return  false;
        }
        Dog d = (Dog)obj;
        if (name.equals(d.name) && age == d.age) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "This is a dog, name: " + name + ". age: " + age;
    }
}
