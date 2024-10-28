package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RaceGame;
import racingcar.utils.InputHandler;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getAttemptCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RaceGame raceGame = new RaceGame(cars, attemptCount);
        raceGame.startRace();
    }
}
