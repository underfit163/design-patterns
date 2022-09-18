package visitor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(
                                     new BufferedReader(
                                             new InputStreamReader(System.in)).readLine()))) {
            Product product = new Product(br.readLine(), Integer.parseInt(br.readLine()));
            for (int i = 0; i < product.getSize(); i++) {
                product.getDetails()[i].setName(br.readLine());
                product.getDetails()[i].setNumber(Integer.parseInt(br.readLine()));
            }
            List<Product> list = new ArrayList<>();
            list.add(product);
            list.forEach(x -> x.accept(visitor));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
