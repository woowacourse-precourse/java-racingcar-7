package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsHandler {

    private final List<Car> cars;
    private final List<String> carNames;

    public CarsHandler(List<String> carNames) {
        this.cars = new ArrayList<>(carNames.size());
        this.carNames = new ArrayList<>(carNames);

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
        // TODO: max 비교할때 Java api 활용 하고싶지만 일단 구현
        int maxStep = 0;
        for (Car car : cars) {
            maxStep = Math.max(maxStep, car.getStep());
        }

        final int finalMaxStep = maxStep;

        return cars.stream()
                .filter(car -> car.getStep() == finalMaxStep)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

}
