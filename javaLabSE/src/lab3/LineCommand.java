package lab3;

import lab124.Car;
import lab124.Transport;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class LineCommand implements Command {

    private Transport transport;

    public LineCommand(Transport transport) {
        this.transport = transport;
    }

    @Override
    public void execute(Writer writer) {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print(transport.getMark() + ":");
        for (int i = 0; i < transport.getSize(); i++) {
            printWriter.print("(" + transport.getNameArray()[i] + ", " + transport.getPayArray()[i] + ") ");
        }
        printWriter.close();
    }
}
