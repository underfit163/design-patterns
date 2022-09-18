import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ProxyServer {

    public static double multiple(double v1, double v2) {
        int serverPort = 5000;
        String address = "localhost";
        double mul = 0;
        try (Socket socket = new Socket(address, serverPort);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            dos.writeDouble(v1);
            dos.writeDouble(v2);
            mul = dis.readDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return mul;
    }
}
