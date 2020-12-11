package TryStringBuffer;

public class TryStringBuffer1 {

    public static void main(String[] args) throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append("Hello ").append("World ").append("!!");
        System.out.println(buf);
        change(buf);
        System.out.println(buf);

        CharSequence seq = "www.google.com";
        System.out.println(seq);

        StringBuffer buf2 = new StringBuffer("www.youtube.com");
        System.out.println("www.youtube.com".contentEquals(buf2));

        // There is a class called StringBuilder which is similar to StringBuffer
        // but all methods of StringBuilder are asynchronous.
    }

    public static void change(StringBuffer buf) {
        buf.append("\n").append("www.github.com");
    }
}
