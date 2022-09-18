public class Client {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        new Director("PRODUCT", builder);
        System.out.println(builder.getProduct().getPr());
    }
}
