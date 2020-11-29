import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkTest {

    @Test
    public void test_size() {
        Link<Integer> l = new Link<>();
        Assert.assertEquals(0, l.size());
    }

    @Test
    public void test_add() {
        Link<Integer> l = new Link<>();
        for (int i = 0; i < 10; i++) {
            l.add(i*11);
        }
        Assert.assertEquals(10, l.size());
    }

    @Test
    public void test_get() throws Exception {
        Link<Integer> l = new Link<>();
        for (int i = 0; i < 10; i++) {
            l.add(i*11);
        }
        for (int i = 0; i <10; i++) {
            Assert.assertEquals(Integer.valueOf(i*11), l.get(i));
        }
    }
}