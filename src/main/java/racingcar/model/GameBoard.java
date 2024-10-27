package racingcar.model;

import java.util.List;

public class GameBoard {
    private final List<Car> cars;

    public GameBoard(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
