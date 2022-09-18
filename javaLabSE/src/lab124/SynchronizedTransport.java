package lab124;

import lab3.Command;
import lab3.Visitor;

import java.io.Writer;

public class SynchronizedTransport implements Transport {

    private Transport transport;

    public SynchronizedTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public synchronized String getMark() {
        return transport.getMark();
    }

    @Override
    public synchronized void setMark(String m) {
        transport.setMark(m);
    }

    @Override
    public synchronized void setName(String name, String newname) throws NoSuchModelNameException, DuplicateModelNameException {
        transport.setName(name, newname);
    }

    @Override
    public synchronized String[] getNameArray() {
        return transport.getNameArray();
    }

    @Override
    public synchronized double[] getPayArray() {
        return transport.getPayArray();
    }

    @Override
    public synchronized int getSize() {
        return transport.getSize();
    }

    @Override
    public synchronized double getPriceModel(String name) throws NoSuchModelNameException {
        return transport.getPriceModel(name);
    }

    @Override
    public synchronized void setPayNew(String name, double pay) throws NoSuchModelNameException {
        transport.setPayNew(name,pay);
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
        transport.addModel(name, price);
    }

    @Override
    public synchronized void dellModel(String name) throws NoSuchModelNameException {
        transport.dellModel(name);
    }

    @Override
    public synchronized void print(Writer writer) {

    }

    @Override
    public synchronized void setPrintCommand(Command command) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
