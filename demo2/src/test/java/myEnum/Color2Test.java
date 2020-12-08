package myEnum;

import org.junit.Test;

import static org.junit.Assert.*;

public class Color2Test {
    @Test
    public void test() {
        for (Color2 c : Color2.values()) {
            System.out.println(c.ordinal() + " - " + c);
        }
    }

}