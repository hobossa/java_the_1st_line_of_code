package USB;

public class Printer implements USB {
    @Override
    public void start() {
        System.out.println("USB.Printer start working.");
    }

    @Override
    public void stop() {
        System.out.println("USB.Printer stop working.");
    }
}
