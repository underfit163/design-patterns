package prototype;

import java.io.*;
import java.util.Iterator;
import java.util.Random;

public class Product implements Cloneable, Serializable {
    private String name;
    private Detail[] details;

    public Product(String name, int n) {
        this.name = name;
        this.details = new Detail[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            this.details[i] = new Detail("", random.nextInt());
        }
    }

    public static class Detail implements Cloneable, Serializable {
        private String name;
        private int number;

        public Detail(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public Detail[] getDetails() {
        return details;
    }

    public int getSize() {
        return details.length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object clone() throws CloneNotSupportedException {
        Product product = (Product) super.clone();
        product.details = new Detail[details.length];
        for (int i = 0; i < details.length; i++) {
            product.details[i] = (Detail) this.details[i].clone();
        }
        return product;
    }

    private class DetailIterator implements Iterator<Detail> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < getSize();
        }

        @Override
        public Detail next() {
            return details[index++];
        }
    }

    public Iterator<Detail> getIterator() {
        return new DetailIterator();
    }

    public static class Memento {
        private byte[] state;

        public void setState(Product product) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(product);
                this.state = baos.toByteArray();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        public Product getState() {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(state);
                 ObjectInputStream oos = new ObjectInputStream(bais)) {
                return (Product) oos.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(this);
        return memento;
    }

    public Product setMemento(Memento memento) {
        return memento.getState();
    }
}
