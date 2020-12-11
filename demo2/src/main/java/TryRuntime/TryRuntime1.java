package TryRuntime;

public class TryRuntime1 {

    public static void main(String[] args) throws Exception {
        Runtime run = Runtime.getRuntime();
        System.out.println("MAX = " + run.maxMemory());
        System.out.println("TOTAL = " + run.totalMemory());
        System.out.println("FREE = " + run.freeMemory());
        run.gc(); // do garbage collect, recycle some memory.
        // Process ps = run.exec("weiyun.app");
        // Thread.sleep(10000);
        // ps.destroy();
    }
}
