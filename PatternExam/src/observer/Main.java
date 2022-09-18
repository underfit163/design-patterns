package observer;

public class Main {
    public static void main(String[] args) {
        Observer o1 = new ConcreteObserver();
        Observer o2 = new ConcreteObserver();
        Observable observable = new CObservable();
        observable.addObserver(o1);
        observable.addObserver(o2);
        observable.notifyObserver();
    }
}
