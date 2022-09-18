package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandMain {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            MyArray myArray = new MyArray(0);
            Command command = new EndCommand(myArray);
            myArray.setCommand(command);
            myArray.runCommand(br.readLine(), br.readLine());
        } catch (IOException e) {
            System.out.println();
        }
    }
}