package proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int serverPort = 5000;
        try (ServerSocket server = new ServerSocket(serverPort);
             Socket socket = server.accept();
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            dos.writeDouble(multiple(dis.readDouble(), dis.readDouble()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double multiple(double p1, double p2) {
        return p1 * p2;
    }
}
