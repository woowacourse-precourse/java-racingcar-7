package racingcar.domain;

import racingcar.util.RandomGeneratorUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.OutputView.printCurrentResult;

public class Cars {
    private final List<Car> cars;
    private static final int MINIMUM_MOVEMENT_THRESHOLD = 4;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            if (getNumberOfMoves()) {
                car.movementOfNumber++;
            }
        }
        printCurrentResult(cars);
    }

    private boolean getNumberOfMoves() {
        int randomNumber = RandomGeneratorUtil.getRandomNumber();
        return randomNumber >= MINIMUM_MOVEMENT_THRESHOLD;
    }

    private int findMaxMovement() {
        return cars.stream()
                .max(Comparator.comparingInt(car -> car.movementOfNumber)).map(car -> car.movementOfNumber).orElse(0);
    }

    public List<String> calculateFinalWinner() {
        int maxMovement = findMaxMovement();
        return cars.stream().filter(car -> car.movementOfNumber == maxMovement).map(carMovement -> carMovement.name)
                .collect(Collectors.toList());

    }
}
