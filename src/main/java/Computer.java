import USB.USB;

public class Computer {
    public void plugin(USB usb) {
        usb.start();
        usb.stop();
    }
}
