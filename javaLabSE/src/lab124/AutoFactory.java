package lab124;

public class AutoFactory implements TransportFactory {

    @Override
    public Transport createInstance(String mark, int n) {
        return new Car(mark,n);
    }
}
