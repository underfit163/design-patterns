package command;

import java.io.Serializable;

public class MyArray implements Serializable {
    private double[] arr;
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public double[] getArr() {
        return arr;
    }

    public int getSize() {
        return arr.length;
    }

    public void runCommand(String file1, String file2) {
        this.command.execute(file1, file2);
    }

    public MyArray(int n) {
        this.arr = new double[n];
    }

    public double getVal(int index) {
        return arr[index];
    }

    public void setVal(int index, double val) {
        this.arr[index] = val;
    }
}
