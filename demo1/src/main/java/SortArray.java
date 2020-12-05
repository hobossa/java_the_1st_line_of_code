public class SortArray extends Array {
    public SortArray(int len) {
        super(len);
    }

    @Override
    public int[] getData() {
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}
