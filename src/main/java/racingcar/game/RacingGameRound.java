package racingcar.game;

import racingcar.dto.Car;
import racingcar.io.OutputHandler;
import racingcar.util.NumberGenerator;
import racingcar.util.Random;

import java.util.List;

public class RacingGameRound {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    private final OutputHandler outputHandler = new OutputHandler();

    public RacingGameRound(List<Car> carList, NumberGenerator numberGenerator) {
        this.cars = carList;
        this.numberGenerator = numberGenerator;
    }

    public RacingGameRound(List<Car> carList) {
        this.cars = carList;
        this.numberGenerator = new Random();
    }

    public void racing() {
        for (Car car : cars) {
            checkConditionAndMove(car);
        }

        outputHandler.printCarsRacingResult(cars);
    }

    private void checkConditionAndMove(Car car) {
        if (numberGenerator.pickNumber() >= 4) {
            car.move();
        }
    }
}
