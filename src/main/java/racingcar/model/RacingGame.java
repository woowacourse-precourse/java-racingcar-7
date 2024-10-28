package racingcar.model;

import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars;
    private final RandomGenerator randomGenerator;
    private final OutputView outputView;

    public RacingGame(Cars cars, RandomGenerator randomGenerator, OutputView outputView) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
        this.outputView = outputView;
    }

    public void start(int times) {
        outputView.printOutputString();
        playRounds(times);
        announceWinners();
    }

    private void playRounds(int times) {
        while (times > 0) {
            playEachRound();
            times -= 1;
        }
    }

    private void playEachRound() {
        moveAllCars();
        outputView.printNewLine();
    }

    private void moveAllCars() {
        for (Car car : cars.getCars()) {
            moveSingleCar(car);
            outputView.printResult(car);
        }
    }

    private void moveSingleCar(Car car) {
        int number = randomGenerator.generateRandomNumber();
        if (randomGenerator.canMoveForward(number)) {
            car.moveForward();
        }
    }

    private void announceWinners() {
        List<Car> winners = cars.findWinners();
        outputView.printWinner(winners);
    }


}
