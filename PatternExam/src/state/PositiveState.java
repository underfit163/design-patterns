package state;

public class PositiveState implements State {

    @Override
    public void handle(MyArray arr) {
        if (arr.getIndex() < arr.getSize()) {
            if (arr.getVal(arr.getIndex()) >= 0) {
                System.out.println("Положительное число");
                arr.setState(new NegativeState());
                if(arr.getIndex() >= arr.getSize()-1) {System.out.println("Успех");}
                arr.upIndex();
                arr.run();
                return;
            }
            System.out.println("Отрицательное число");
            System.out.println("Не знакочередующиеся");
        }
    }
}
