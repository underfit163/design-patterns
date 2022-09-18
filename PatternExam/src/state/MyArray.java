package state;

import command.Command;

import java.io.Serializable;
import java.util.Random;

public class MyArray implements Serializable {
    private int[] arr;
    private State state;
    private int index = 0;

    public void upIndex() {
        this.index++;
    }

    public int getIndex() {
        return index;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void run() {
        this.state.handle(this);
    }

    public MyArray(int n) {
        this.arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                arr[i] = (random.nextInt(100 - 10) + 10) * -1;
                System.out.println(arr[i]);
            } else {
                arr[i] = (random.nextInt(100 - 10) + 10);
                System.out.println(arr[i]);

            }
        }
        arr[arr.length - 1] = (random.nextInt(100 - 10) + 10) * -1;
        System.out.println(arr[arr.length - 1]);
    }

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return arr.length;
    }

    public double getVal(int index) {
        return arr[index];
    }

    public void setVal(int index, int val) {
        this.arr[index] = val;
    }
}
