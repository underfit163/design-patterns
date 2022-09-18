package lab124;

import lab3.Command;
import lab3.Visitor;

import java.io.Serializable;
import java.io.Writer;

public class Bike implements Transport, Serializable, Cloneable {
    private String mark;
    private Model head = new Model();

    {
        head.prev = head;
        head.next = head;
    }

    private int size = 0;

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String m) {
        this.mark = m;
    }

    public Bike(String mark, int n) throws DuplicateModelNameException {
        this.mark = mark;
        for (int i = 0; i < n; i++) {
            addModel("модель" + i, 20);
        }
    }

    private static class Model implements Serializable, Cloneable {
        private String name = null;
        private double pay = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {
        }

        public Model(String name, double pay) {
            this.name = name;
            this.pay = pay;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Override
    public void addModel(String name, double pay) throws DuplicateModelNameException {
        if (pay < 0) throw new ModelPriceOutOfBoundsException(pay);
        Model model = new Model(name, pay);
        if (head.next == head) {
            model.next = head;
            model.prev = head;
            head.next = model;
            head.prev = model;
        } else {
            testDuplicate(name);
            model.next = head;
            model.prev = head.prev;
            head.prev.next = model;
            head.prev = model;
        }
        size++;
    }

    @Override
    public void setName(String name, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        Model p = head.next;
        int id = -1;
        for (int i = 0; i < size; i++) {
            if (p.name.equals(name)) {
                id = i;
                break;
            }
            p = p.next;
        }
        testDuplicate(newName);
        if (id == -1) throw new NoSuchModelNameException(name);
        else p.name = newName;
    }

    @Override
    public String[] getNameArray() {
        String[] namearr = new String[size];
        Model p = head.next;
        int i = 0;
        if (p == null)
            return null;
        do {
            namearr[i++] = p.name;
            p = p.next;
        } while (p != head);
        return namearr;
    }

    @Override
    public double getPriceModel(String name) throws NoSuchModelNameException {
        Model p = head.next;
        if (p == null)
            return 0;
        do {
            if (p.name.equals(name)) {
                return p.pay;
            }
            p = p.next;
        } while (p != head);
        throw new NoSuchModelNameException(name);
    }

    @Override
    public void setPayNew(String name, double pay) throws NoSuchModelNameException {
        if (pay < 0) throw new ModelPriceOutOfBoundsException(pay);
        Model p = head.next;
        int id = -1;
        for (int i = 0; i < size; i++) {
            if (p.name.equals(name)) {
                id = i;
                break;
            }
            p = p.next;
        }
        if (id == -1) throw new NoSuchModelNameException(name);
        else p.pay = pay;
    }

    @Override
    public double[] getPayArray() {
        double[] payarr = new double[size];
        Model p = head.next;
        int i = 0;
        if (p == null)
            return null;
        do {
            payarr[i++] = p.pay;
            p = p.next;
        } while (p != head);
        return payarr;
    }

    public void testDuplicate(String nameNew) throws DuplicateModelNameException {
        Model test = head.next;
        do {
            if (test.name.equals(nameNew)) {
                throw new DuplicateModelNameException(nameNew);
            }
            test = test.next;
        } while (test != head);
    }

    @Override
    public void dellModel(String name) throws NoSuchModelNameException {
        {
            Model p = head;
            do {
                p = p.next;
            } while ((p.next != head) && (!p.name.equals(name)));
            if (!p.name.equals(name)) throw new NoSuchModelNameException(name);
            p.prev.next = p.next;
            p.next.prev = p.prev;
            size--;
        }
    }

        @Override
        public int getSize () {
            return size;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Bike bike = (Bike) super.clone();
            bike.head = new Model();
            bike.head.prev = bike.head;
            bike.head.next = bike.head;
            Model p = this.head.next;
            while (p != this.head) {
                Model cModel = (Model) p.clone();
                bike.head.prev.next = cModel;
                cModel.next = bike.head;
                cModel.prev = bike.head.prev;
                bike.head.prev = cModel;
                p = p.next;
            }
            return bike;
        }

        private Command command;

        public void setPrintCommand (Command command){
            this.command = command;
        }

        public void print (Writer writer){
            command.execute(writer);
        }

        //3.9
        @Override
        public void accept (Visitor visitor){
            visitor.visit(this);
        }
    }
