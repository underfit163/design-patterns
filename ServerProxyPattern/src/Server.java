import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int serverPort = 5000;
        try (ServerSocket serverSocket = new ServerSocket(serverPort);
             Socket clientSocket = serverSocket.accept();
             DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())) {

            dos.writeDouble(multiple(dis.readDouble(), dis.readDouble()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double multiple(double v1, double v2) {
        return v1 * v2;
    }
}
