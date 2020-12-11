package TryEnum;

import org.junit.Test;

public class Color2Test {
    @Test
    public void test() {
        for (Color2 c : Color2.values()) {
            System.out.println(c.ordinal() + " - " + c);
        }
    }

}