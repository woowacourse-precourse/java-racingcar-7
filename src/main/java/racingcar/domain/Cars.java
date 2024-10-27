package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandNumGenerator;

public class Cars {
    private static final String INPUT_DELIM = ",";

    private final List<Car> cars;

    public Cars(String carsNames) {
        String[] splitNames = carsNames.split(INPUT_DELIM);
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .toList();
    }

    public void roundProcess(RandNumGenerator randNumGenerator) {
        for (Car car : cars) {
            car.moveForward(randNumGenerator.isRandNumGreaterThanOrEqualToCriterion());
        }
    }

    public String roundStatus() {
        StringBuilder roundStatus = new StringBuilder();

        for (Car car : cars) {
            roundStatus.append(car.getCurrentStatus());
        }
        return roundStatus.toString();
    }

    public List<String> findWinners() {
        Car frontLineCar = findFrontLineCar();
        return findCoWinner(frontLineCar);
    }

    private Car findFrontLineCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElse(null);
    }

    private List<String> findCoWinner(Car frontLineCar) {
        return cars.stream()
                .filter(frontLineCar::isCarSamePosition)
                .map(Car::getName)
                .toList();
    }
}
