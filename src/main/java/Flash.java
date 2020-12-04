public class Flash implements USB {
    @Override
    public void start() {
        System.out.println("start using flash disk.");
    }

    @Override
    public void stop() {
        System.out.println("stop using flash disk");
    }
}
