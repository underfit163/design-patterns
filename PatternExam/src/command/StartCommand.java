package command;

import java.io.*;
import java.util.Arrays;

public class StartCommand implements Command {

    private MyArray myArray;

    public StartCommand(MyArray myArray) {
        this.myArray = myArray;
    }

    @Override
    public void execute(String file1, String file2) {
        try (BufferedReader br = new BufferedReader(new FileReader(file1));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))) {
            myArray = new MyArray(Integer.parseInt(br.readLine()));
            for (int i = 0; i < myArray.getSize(); i++) {
                myArray.setVal(i, Double.parseDouble(br.readLine()));
            }
            for (int i = 1; i < myArray.getSize(); i++) {
                for (int j = i; j >= 1; j--) {
                    if (myArray.getVal(j) == 0) {
                        double temp = myArray.getVal(j);
                        myArray.setVal(j, myArray.getVal(j - 1));
                        myArray.setVal(j - 1, temp);
                    }
                }
            }
            System.out.println(Arrays.toString(myArray.getArr()));
            oos.writeObject(myArray.getArr());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
