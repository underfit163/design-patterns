package templateMethod;

public class ConcreteTemplate extends Template{
    @Override
    public void Op1() {
        System.out.println("Операция 1");
    }

    @Override
    public void Op2() {
        System.out.println("Операция 2");
    }
}
