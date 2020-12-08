package myEnum;

import org.junit.Test;

import static org.junit.Assert.*;

public class Color4Test {
    @Test
    public void test() {
        for (Color4 c : Color4.values()) {
            System.out.println(c.ordinal() + " - " + c.getTitle());
        }
    }
}