package lab3;

import lab124.Transport;

import java.io.IOException;

public interface Handler {
    void write(Transport transport) throws IOException;
    void setNextHandler(Handler nextHandler);
}
