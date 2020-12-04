public class Printer implements USB {
    @Override
    public void start() {
        System.out.println("Printer start working.");
    }

    @Override
    public void stop() {
        System.out.println("Printer stop working.");
    }
}
