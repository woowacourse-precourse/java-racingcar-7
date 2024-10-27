package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandNumGenerator;
import racingcar.view.OutputView;

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

    public void roundStatus() {
        OutputView outputView = OutputView.getInstance();
        StringBuilder roundResult = new StringBuilder();
        for (Car car : cars) {
            roundResult.append(car.getCurrentStatus());
        }
        outputView.printRoundResult(roundResult.toString());
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
