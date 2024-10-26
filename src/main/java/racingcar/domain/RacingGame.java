package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;
    private final CarMover carMover;
    private final WinnerCalculator winnerCalculator;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.carMover = new CarMover();
        this.winnerCalculator = new WinnerCalculator();
    }

    public void playRound() {
        for (Car car : cars) {
            carMover.moveCar(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }

    public List<Car> getWinners() {
        return winnerCalculator.calculateWinners(cars);
    }
}
