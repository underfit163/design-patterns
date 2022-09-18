package lab124;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class CreationThread implements Runnable {
    private String filename;
    private ArrayBlockingQueue<Transport> abq;

    public CreationThread(String filename, ArrayBlockingQueue<Transport> abq) {
        this.abq = abq;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String mark = br.readLine();
            Transport t = new Car(mark, 0);
            abq.add(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}