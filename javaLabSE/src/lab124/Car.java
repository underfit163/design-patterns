package lab124;

import lab3.Command;
import lab3.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Transport, Serializable, Cloneable {
    private String mark;
    private Model[] models;

    public Car(String mark, int n) {
        this.mark = mark;
        models = new Model[n];
        for (int i = 0; i < n; i++) {
            models[i] = new Model("model" + i, 100);
        }
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    public static class Model implements Serializable, Cloneable {
        private String name;
        private double pay;

        public Model(String name, double pay) {
            this.name = name;
            this.pay = pay;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPay() {
            return pay;
        }

        public void setPay(double pay) {
            this.pay = pay;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "name=" + name + ", pay=" + pay;
        }
    }

    @Override
    public void setName(String name, String newname) throws DuplicateModelNameException, NoSuchModelNameException {
        int index = -1;
        for (int i = 0; i < models.length; i++) {
            if (models[i].name.equals(newname)) {
                throw new DuplicateModelNameException(newname);
            } else if (models[i].name.equals(name)) {
                index = i;
            }
        }
        if (index == -1) throw new NoSuchModelNameException(name);
        else models[index].name = newname;
    }

    @Override
    public String[] getNameArray() {
        //String[] a = Arrays.stream(models).map(Model::getName).toArray(String[]::new);
        String[] a = new String[models.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = models[i].getName();
        }
        return a;
    }

    @Override
    public double getPriceModel(String name) throws NoSuchModelNameException {
        for (int i = 0; i < models.length; i++) {
            if (models[i].getName().equals(name)) {
                return models[i].getPay();
            }
        }
        throw new NoSuchModelNameException(name);
    }

    @Override
    public void setPayNew(String name, double pay) throws NoSuchModelNameException {
        if (pay < 0) throw new ModelPriceOutOfBoundsException(pay);
        for (int i = 0; i < models.length; i++) {
            if (models[i].getName().equals(name)) {
                models[i].setPay(pay);
                return;
            }
        }
        throw new NoSuchModelNameException(name);
    }

    @Override
    public double[] getPayArray() {
        double[] a = new double[models.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = models[i].getPay();
        }
        return a;
    }

    @Override
    public void addModel(String name, double pay) throws DuplicateModelNameException {
        if (pay < 0) throw new ModelPriceOutOfBoundsException(pay);
        int newLeng = models.length + 1;
        for (int i = 0; i < models.length; i++) {
            if (models[i].name.equals(name)) throw new DuplicateModelNameException(name);
        }
        models = Arrays.copyOf(models, newLeng);
        models[newLeng - 1] = new Model(name, pay);
    }

    @Override
    public void dellModel(String name) throws NoSuchModelNameException {
        int id = -1;
        for (int i = 0; i < models.length; i++) {
            if (name.equals(models[i].getName())) {
                id = i;
                break;
            }
        }
        if (id == -1) throw new NoSuchModelNameException(name);
        System.arraycopy(models, id + 1, models, id, models.length - 1 - id);
        models = Arrays.copyOf(models, models.length - 1);
    }

    @Override
    public int getSize() {
        return models.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        car.models = new Model[getSize()];
        for (int i = 0; i < getSize(); i++) {
            car.models[i] = (Model) this.models[i].clone();
        }
        return car;
    }

    //3.2
    private Command command;

    public void setPrintCommand(Command command) {
        this.command = command;
    }

    public void print(Writer writer) {
        command.execute(writer);
    }

    //3.3
    private class AutoIterator implements Iterator<Model> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < models.length;
        }

        @Override
        public Model next() {
            return models[index++];
        }

        @Override
        public void remove() {
            System.arraycopy(models, 1, models, 0, models.length - 1);
            models = Arrays.copyOf(models, models.length - 1);
        }
    }

    public Iterator<Model> iterator() {
        return new AutoIterator();
    }

    //3.4
    public static class Memento {
        private static byte[] state;

        public void setAuto(Car car) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(car);
            oos.flush();
            state = baos.toByteArray();
        }


        public Car getAuto() throws IOException, ClassNotFoundException {
            ByteArrayInputStream bais = new ByteArrayInputStream(state);
            ObjectInputStream dis = new ObjectInputStream(bais);
            return (Car) dis.readObject();
        }
    }

    public Memento createMemento() throws IOException {
        Memento memento = new Memento();
        memento.setAuto(this);
        return memento;
    }

    public Car setMemento(Memento memento) throws DuplicateModelNameException, IOException, ClassNotFoundException {
        return memento.getAuto();
    }

    //3.9
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}