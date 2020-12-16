package TryReflection;

import java.lang.reflect.InvocationTargetException;

interface Fruit {
    public void eat();
}

class Apple implements Fruit {

    @Override
    public void eat() {
        System.out.println("eat an apple.");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat an orange.");
    }
}

class FruitFactory {
    public static Fruit getInstance(String className) {
        Fruit f = null;
        try {
            f = (Fruit)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }
}

public class TestFactory {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.getInstance("TryReflection.Apple");
        Fruit orange = FruitFactory.getInstance("TryReflection.Orange");
        apple.eat();
        orange.eat();
    }
}
