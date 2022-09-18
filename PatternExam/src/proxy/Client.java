package proxy;

public class Client implements Proxy {
    @Override
    public double request(double n1, double n2) {
        return n1 * n2;
    }
}
