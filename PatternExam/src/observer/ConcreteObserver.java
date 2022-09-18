package observer;

public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        System.out.println("Я как обсервер реагирую на изменение обозримого объекта");
    }
}
