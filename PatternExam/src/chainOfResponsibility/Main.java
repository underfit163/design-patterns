package chainOfResponsibility;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("file1");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(10);
        dos.writeDouble(1);
        dos.writeDouble(2);
        dos.writeDouble(3);
        dos.writeDouble(4);
        dos.writeDouble(5);
        dos.writeDouble(6);
        dos.writeDouble(7);
        dos.writeDouble(8);
        dos.writeDouble(9);
        dos.writeDouble(10);
        dos.close();

        Handler handler = new EvenHandler();
        handler.setNext(new OddHandler());
        //Scanner scanner = new Scanner(System.in);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            handler.readWrite(br.readLine(), br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
