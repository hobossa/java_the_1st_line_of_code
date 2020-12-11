package TryEnum;

import org.junit.Test;

public class Color4Test {
    @Test
    public void test() {
        for (Color4 c : Color4.values()) {
            System.out.println(c.ordinal() + " - " + c.getTitle());
        }
    }
}