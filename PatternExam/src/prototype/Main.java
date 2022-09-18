package prototype;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Product product = new Product("product1", 4);
            Product productClone = (Product) product.clone();
            product.getDetails()[1].setName("newName");
            System.out.println(Arrays.toString(product.getDetails()));
            System.out.println(Arrays.toString(productClone.getDetails()));

            Iterator<Product.Detail> iterator = product.getIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            Product.Memento memento = product.createMemento();
            System.out.println(Arrays.toString(product.getDetails()));
            product.getDetails()[2].setName("Memento");
            System.out.println(Arrays.toString(product.getDetails()));
            product = product.setMemento(memento);
            System.out.println(Arrays.toString(product.getDetails()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
