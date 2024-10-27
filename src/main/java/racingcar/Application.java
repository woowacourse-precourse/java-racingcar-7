package racingcar;

import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.RaceHandler;
import racingcar.input.InputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    private static void start() {

        InputHandler inputHandler = new InputHandler();

        inputHandler.promptCarNames();

        String carNames = inputHandler.receiveCarNames();

        inputHandler.promptRaceCount();

        long raceCount = inputHandler.receiveRaceCount();

        inputHandler.validateInput(carNames, raceCount);

        CarFactory carFactory = new CarFactory();

        List<Car> cars = carFactory.createCars(carNames);

        RaceHandler raceHandler = new RaceHandler();

        raceHandler.race(cars, raceCount);

    }


}
