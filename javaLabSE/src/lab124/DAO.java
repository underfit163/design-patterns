package lab124;

import java.io.IOException;

public interface DAO {
     void writeTransport(Transport transport, String fileName) throws  IOException;
    Transport readTransport(String fileName) throws IOException, DuplicateModelNameException, ClassNotFoundException;
}
