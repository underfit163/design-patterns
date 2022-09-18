package lab124;

public class TransportSynchronizer {
    private Transport v;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = false;

    public TransportSynchronizer(Transport v)
    {
        this.v = v;
    }

    public double printPrice() throws InterruptedException
    {
        double val;
        synchronized(lock)
        {
            System.out.println("printPrice");
            double [] p = v.getPayArray();
            if (!canPrintPrice()) throw new InterruptedException();
            //Можно же здесь использовать if вместо while
            while(!set)
                /*после освобождения ожидающего потока методом notifyAll() он захватит объект lock и выполнит оставшуюся часть метода
                * без возможности другим захватить этот объект?*/
                lock.wait();
            val = p[current++];
            System.out.println("Print price: " + val);
            set = false;
            lock.notifyAll();
            System.out.println("printPrice");
        }
        return val;
    }

    public void printModel() throws InterruptedException
    {
        synchronized(lock)
        {
            System.out.println("printModel");
            String [] s = v.getNameArray();
            if (!canPrintModel()) throw new InterruptedException();
            while(set)
                lock.wait();
            System.out.println("Print model: " + s[current]);
            set = true;
            lock.notifyAll();
            System.out.println("printModel");
        }
    }

    public boolean canPrintPrice()
    {
        return current < v.getSize();
    }

    public boolean canPrintModel()
    {
        return (!set && current < v.getSize()) || (set && current < v.getSize() - 1);

    }
}