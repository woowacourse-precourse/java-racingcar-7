package racingcar.domain;

import racingcar.util.RandomGeneratorUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.OutputView.printCurrentResult;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(getNumberOfMoves());
        }
        printCurrentResult(cars);
    }

    private int getNumberOfMoves() {
        return RandomGeneratorUtil.getRandomNumber();
    }

    private int findMaxMovement() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getMovementOfNumber)).map(Car::getMovementOfNumber).orElse(0);
    }

    public List<String> calculateFinalWinner() {
        int maxMovement = findMaxMovement();
        return cars.stream().filter(car -> car.getMovementOfNumber() == maxMovement).map(Car::getName)
                .collect(Collectors.toList());

    }
}
