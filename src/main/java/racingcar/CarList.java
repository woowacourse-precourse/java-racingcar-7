package racingcar;

import java.util.ArrayList;

public class CarList {
    ArrayList<Car> cars = new ArrayList<>();
    public ArrayList<Car> getCars() {
        return cars;
    }
    public Car getCar(int carNumber) {
        return cars.get(carNumber);
    }
    public void addCar(Car car) {
        cars.add(car);
    }
}
