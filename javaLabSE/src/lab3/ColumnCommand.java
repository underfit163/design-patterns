package lab3;

import lab124.Car;
import lab124.Transport;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class ColumnCommand implements Command {

    private Transport transport;

    public ColumnCommand(Transport transport) {
        this.transport = transport;
    }

    @Override
    public void execute(Writer writer) {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(transport.getMark() + ":");
        for (int i = 0; i < transport.getSize(); i++) {
            printWriter.println("(" + transport.getNameArray()[i] + ", "+ transport.getPayArray()[i] + ") ");
        }
        printWriter.close();
    }
}
