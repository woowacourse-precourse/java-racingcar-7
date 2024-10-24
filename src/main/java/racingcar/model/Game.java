package racingcar.model;

import racingcar.model.random.NumberGenerator;

import java.util.List;

public class Game {
    private List<Car> cars;
    private Referee referee;
    private NumberGenerator numberGenerator;

    public Game(List<Car> cars, Referee referee, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.referee = referee;
        this.numberGenerator = numberGenerator;
    }

    public void playOneRound() {
        tryMoveAllCars();
    }

    private void tryMoveAllCars() {
        for (Car car : cars) {
            car.tryForwardLevelUp(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners() {
        return referee.determineWinners(cars);
    }
}
