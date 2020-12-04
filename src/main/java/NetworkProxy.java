public class NetworkProxy implements Network {
    private Network network;

    public NetworkProxy(Network network) {
        this.network = network;
    }

    public void check() {
        System.out.println("check if it is an authentic user.");
    }

    @Override
    public void browse() {
        this.check();
        this.network.browse();
    }
}
