package proxy.my;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Должен быть 1 параметр");
        } else {
            try (Socket socket = new Socket("localhost", 5000);
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                 DataInputStream dis = new DataInputStream(socket.getInputStream())
            ) {
                Random r = new Random();
                double[] mas = new double[Integer.parseInt(args[0])];
                for (int i = 0; i < mas.length-3; i++) {
                    mas[i] = 3;
                }
                mas[2] = 2;
                mas[3] = 2;
                mas[4] = 3;
                System.out.println();
                oos.writeObject(mas);
                System.out.println(dis.readInt());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
