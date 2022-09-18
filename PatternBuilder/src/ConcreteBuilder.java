public class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void BuildPart(String string) {
        product.setPr(string.toLowerCase());
    }

    public Product getProduct() {
        return product;
    }
}
