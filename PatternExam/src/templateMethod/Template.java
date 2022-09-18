package templateMethod;

public abstract class Template {

    public void templateMethod() {
        Op1();
        System.out.println("Операция общая");
        Op2();
    }

    public abstract void Op1();
    public abstract void Op2();
}
