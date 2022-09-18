package lab124;

import java.io.*;

public class TextDAO implements DAO {
    private TransportFactory transportFactory = new AutoFactory();

    public void setTransportFactory(TransportFactory factory1) {
        transportFactory = factory1;
    }

    public Transport createInstance(String name, int size) throws DuplicateModelNameException {
        return transportFactory.createInstance(name, size);
    }

    @Override
    public void writeTransport(Transport transport, String fileName) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
        printWriter.println(transport.getMark());
        printWriter.println(transport.getSize());
        for (int i = 0; i < transport.getSize(); i++) {
            printWriter.println(transport.getNameArray()[i]);
            printWriter.println(transport.getPayArray()[i]);
        }
        printWriter.flush();
    }

    @Override
    public Transport readTransport(String fileName) throws IOException, DuplicateModelNameException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String mark = bufferedReader.readLine();
        int len = Integer.parseInt(bufferedReader.readLine());
        double price;
        String model;
        Transport t = createInstance(mark, 0);
        for (int i = 0; i < len; i++) {
            model = bufferedReader.readLine();
            price = Double.parseDouble(bufferedReader.readLine());
            if (t != null) {
                t.addModel(model, price);
            }
        }
        return t;
    }
}
