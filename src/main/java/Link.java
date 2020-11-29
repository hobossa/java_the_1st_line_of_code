import java.lang.invoke.VarHandle;

public class Link<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head, tail;
    private int size;

    public Link() {
        head = tail = new Node<E>(null);
        size = 0;
    }

    public void add(E value) {
        tail.next = new Node<E>(value);
        tail = tail.next;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E value) {
        Node<E> p = head.next;
        while (p != null) {
            if (p.data.equals(value)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    private Node<E> at(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("out of range");
        }
        int n = index;
        Node<E> p = head.next;
        while (index-- > 0) {
            p = p.next;
        }
        return p;
    }

    public E get(int index) throws Exception {
        Node<E> p = at(index);
        return p.data;
    }

    public void set(int index, E value) throws Exception {
        Node<E> p = at(index);
        p.data = value;
    }

    public void remove(E value) {
        Node<E> p = head;
        while (p.next != null) {
            if (p.next.data.equals(value)) {
                p.next = p.next.next;
                size--;
            } else {
                p = p.next;
            }
        }
    }

    public E[] toArray() {
        return null;
    }

    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }
}
