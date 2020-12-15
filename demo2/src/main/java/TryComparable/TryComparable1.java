package TryComparable;

import java.util.Arrays;

class Book implements Comparable<Book> {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "title: " + title + ", price: " + price + "\n";
    }

    @Override
    public int compareTo(Book book) {
        if (this.price > book.price) {
            return 1;
        } else if (this.price < book.price) {
            return -1;
        } else {
            return 0;
        }
    }
}

@SuppressWarnings("rawtypes")
class BinaryTree {
    private class Node {
        private Comparable data;
        private Node left;
        private Node right;

        public Node(Comparable data) {
            this.data = data;
        }

        @SuppressWarnings("unchecked")
        public void addNode(Node newNode) {
            if (this.data.compareTo(newNode.data) > 0) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }
            BinaryTree.this.retData[BinaryTree.this.foot++] = this.data;

            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
    }

    private Node root;
    private int count;
    private Object[] retData;
    private int foot;

    public void add(Object obj) {
        Comparable com = (Comparable) obj;
        Node newNode = new Node(com);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public Object[] toArray() {
        if (this.root == null) {
            return null;
        }
        this.foot = 0;
        this.retData = new Object[this.count];
        this.root.toArrayNode();
        return this.retData;
    }
}

public class TryComparable1 {
    public static void main(String[] args) {
        Book books[] = new Book[]{
                new Book("Java Programming", 79.8),
                new Book("Java in Action", 69.8),
                new Book("Java Spring", 99.8),
                new Book("Android Development", 89.8)
        };
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));

        BinaryTree bt = new BinaryTree();
        bt.add(new Book("Java Programming", 79.8));
        bt.add(new Book("Java in Action", 69.8));
        bt.add(new Book("Java Spring", 99.8));
        bt.add(new Book("Android Development", 89.8));
        Object obj[] = bt.toArray();
        System.out.println(Arrays.toString(obj));
    }
}
