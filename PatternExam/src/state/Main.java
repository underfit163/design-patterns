package state;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(7);
        if(myArray.getVal(0) >= 0) {
            State state = new PositiveState();
            myArray.setState(state);
        } else {
            State state = new NegativeState();
            myArray.setState(state);
        }
        myArray.run();
    }
}
