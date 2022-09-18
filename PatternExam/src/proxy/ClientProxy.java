package proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class ClientProxy implements Proxy {

    private Client client;

    @Override
    public double request(double n1, double n2) {
        double mul = Double.NaN;
        try (Socket socket = new Socket("localhost", 5000);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            dos.writeDouble(n1);
            dos.writeDouble(n2);
            mul = dis.readDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (Double.isNaN(mul)) {
            if (client == null) {
                client = new Client();
                mul = client.request(n1, n2);
            }
        }
        return mul;
    }
}
