package lab124;

import java.util.concurrent.locks.ReentrantLock;

public class LockModelsThread implements Runnable {
    private Transport transport;
    private ReentrantLock lock;//

    public LockModelsThread(Transport transport, ReentrantLock lock) {
        this.transport = transport;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            String[] arr = transport.getNameArray();
            for (String s : arr) {
                System.out.println(s);
            }
        } finally {
            lock.unlock();
        }
    }
}