package racingcar.domain;

import static racingcar.view.OutputView.printCurrentResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomGeneratorUtil;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomGeneratorUtil.getRandomNumber();
            if (randomNumber >= 4) {
                car.movementOfNumber++;
            }
        }
        printCurrentResult(cars);

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
