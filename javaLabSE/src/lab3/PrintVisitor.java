package lab3;

import lab124.Bike;
import lab124.Car;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Car car) {
        System.out.print(car.getMark() + ": ");
        for (int i = 0; i < car.getSize(); i++) {
            System.out.print(car.getNameArray()[i] + " " + car.getPayArray()[i] + " ");
        }
    }

    @Override
    public void visit(Bike bike) {
        System.out.println("\n" + bike.getMark() + ":");
        for (int i = 0; i < bike.getSize(); i++) {
            System.out.println(bike.getNameArray()[i]);
            System.out.println(bike.getPayArray()[i]);
        }
    }
}
