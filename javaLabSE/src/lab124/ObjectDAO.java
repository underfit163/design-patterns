package lab124;

import java.io.*;

public class ObjectDAO implements DAO {
    @Override
    public void writeTransport(Transport transport, String fileName) throws IOException {
        ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(fileName));
        out2.writeObject(transport);
        out2.close();
    }

    @Override
    public Transport readTransport(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Transport transport = (Transport) ois.readObject();
        ois.close();

        return transport;
    }
}
