public class Array {
    private int data[];     // 定义一个数组对象，此数组由外部设置长度。
    private int foot;       // 表示数组的操作脚标。

    public Array(int len) {
        if (len > 0) {
            this.data = new int[len];
        } else {
            this.data = new int[1];
        }
    }

    public boolean add(int num) {
        if (foot < data.length) {
            data[foot++] = num;
            return true;
        } else {
            return false;
        }
    }

    public int[] getData() {
        return data;
    }
}
