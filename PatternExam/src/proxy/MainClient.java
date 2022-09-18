package proxy;

public class MainClient {
    public static void main(String[] args) {
        Proxy proxy = new ClientProxy();
        System.out.println(proxy.request(2,6));
    }
}
