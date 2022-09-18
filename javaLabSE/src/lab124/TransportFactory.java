package lab124;

public interface TransportFactory {
    Transport createInstance(String mark, int n) throws DuplicateModelNameException;
}
