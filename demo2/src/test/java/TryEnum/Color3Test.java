package TryEnum;

import org.junit.Test;

public class Color3Test {
    @Test
    public void test() {
        for (Color3 c : Color3.values()) {
            System.out.println(c.ordinal() + " - " + c.getTitle());
        }
    }
}