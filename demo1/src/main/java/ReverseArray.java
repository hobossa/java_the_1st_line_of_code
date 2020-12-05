public class ReverseArray extends Array{
    public ReverseArray(int len) {
        super(len);
    }

    @Override
    public int[] getData() {
        int head = 0;
        int tail = super.getData().length - 1;
        while (head < tail) {
            int temp = super.getData()[head];
            super.getData()[head] = super.getData()[tail];
            super.getData()[tail] = temp;
            head++;
            tail--;
        }
        return super.getData();
    }
}
