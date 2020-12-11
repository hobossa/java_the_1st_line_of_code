package TryEnum;

import org.junit.Test;

public class Color1Test {
    @Test
    public void test() {
        for (Color1 c : Color1.values()) {
            System.out.println(c.ordinal() + " - " + c.name());
        }
    }
}