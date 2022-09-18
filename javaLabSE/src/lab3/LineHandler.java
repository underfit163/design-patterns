package lab3;

import lab124.Transport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LineHandler implements Handler{
    private Handler nextHandler;
    private int size;

    public LineHandler(int size) {
        this.size = size;
    }

    @Override
    public void write(Transport transport) throws IOException {
        if(transport.getSize()<= size) {
            PrintWriter printWriter = new PrintWriter(new FileWriter("Transport " + transport.getMark()));
            printWriter.print(transport.getMark() + ":");
            for (int i = 0; i < transport.getSize(); i++) {
                printWriter.print("(" + transport.getNameArray()[i] + ", "+ transport.getPayArray()[i] + ") ");
            }
            printWriter.close();
        } else {
            nextHandler.write(transport);
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
