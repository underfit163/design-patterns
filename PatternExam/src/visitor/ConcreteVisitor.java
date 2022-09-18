package visitor;

import java.io.*;

public class ConcreteVisitor implements Visitor {
    @Override
    public void print(Product product) {
        try (PrintWriter pr = new PrintWriter(
                new FileWriter(
                        new BufferedReader(
                                new InputStreamReader(System.in)).readLine()))) {
            pr.println(product.getName());
            pr.println(product.getSize());
            for (int i = 0; i < product.getSize(); i++) {
                pr.println(product.getDetails()[i].getName());
                pr.println(product.getDetails()[i].getNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
