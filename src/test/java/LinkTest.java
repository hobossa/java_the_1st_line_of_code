import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkTest {

    @Test
    public void test_add_size() {
        Link<Integer> l = new Link<>();
        Assert.assertEquals(0, l.size());
        for (int i = 0; i < 10; i++) {
            l.add(i * 11);
            assertEquals(i + 1, l.size());
        }
    }

    @Test
    public void test_get() throws Exception {
        Link<Integer> l = new Link<>();
        for (int i = 0; i < 10; i++) {
            l.add(i * 11);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i * 11), l.get(i));
        }
    }

    @Test
    public void test_contains() {
        Link<Integer> l = new Link<>();
        l.add(1234);
        assertTrue(l.contains(1234));
    }

    @Test
    public void test_remove() {
        Link<Integer> l = new Link<>();
        l.add(1);
        l.add(1234);
        l.add(1234);
        l.add(4);
        int n = l.size();
        l.remove(1234);
        assertFalse(l.contains(1234));
        assertEquals(n-2, l.size());
    }

    @Test
    public void test_set() throws Exception {
        Link<Integer> l = new Link<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
            l.set(i, i * 10);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i*10), l.get(i));
        }
    }

    @Test
    public void test_toArray() {
        
    }
}