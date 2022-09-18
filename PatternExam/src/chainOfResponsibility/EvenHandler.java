package chainOfResponsibility;

import java.io.*;
import java.util.Arrays;

public class EvenHandler implements Handler {

    private Handler handler;
    private double[] mas;

    @Override
    public void readWrite(String file1, String file2) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file1))) {
            int len = dis.readInt();
            double el = dis.readDouble();
            if (el % 2 == 0) {
                PrintWriter pw = new PrintWriter(new FileWriter(file2));
                double p;
                mas = new double[0];
                for (int i = 0; i < len - 1; i++) {
                    p = dis.readDouble();
                    if (Math.floor(p) % 2 != 0) {
                        mas = Arrays.copyOf(mas, mas.length + 1);
                        mas[mas.length-1] = p;
                    }
                }
                pw.println(mas.length);
                for (double ma : mas) {
                    pw.println(ma);
                }
                pw.close();
            } else {
                handler.readWrite(file1, file2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setNext(Handler handler) {
        this.handler = handler;
    }
}
