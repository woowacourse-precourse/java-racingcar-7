package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsHandler {

    private final List<Car> cars;
    private final String[] carNames;

    public CarsHandler(String[] carNames) {
        this.cars = new ArrayList<>(carNames.length);
        this.carNames = carNames;

        setCars();
    }

    private void setCars() {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.randomMove();
        }
    }

    public List<Car> getWinners() {
        int maxStep = cars.stream().mapToInt(Car::getStep).max().orElse(0);

        return cars.stream()
                .filter(car -> car.getStep() == maxStep)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

}
