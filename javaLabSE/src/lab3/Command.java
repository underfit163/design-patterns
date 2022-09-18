package lab3;

import lab124.Transport;

import java.io.Writer;

public interface Command {
    void execute(Writer writer);
}
