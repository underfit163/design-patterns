package lab3;

import lab124.Bike;
import lab124.Car;

public interface Visitor {
    void visit(Car car);
    void visit(Bike bike);
}
