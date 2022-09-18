package lab124;

public class BikeFactory implements TransportFactory {
    @Override
    public Transport createInstance(String mark, int n) throws DuplicateModelNameException {
        return new Bike(mark, n);
    }
}
