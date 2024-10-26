package racingcar.domain;

import java.util.List;

public class Race {
    private final Round round;
    private final List<Car> cars;
    private final RaceRule raceRule;

    public Race(Round round, List<Car> cars, RaceRule raceRule) {
        this.round = round;
        this.cars = cars;
        this.raceRule = raceRule;
    }

    public List<Car> proceed() {
        // TODO: 중복호출방지

        moveAllCars();

        if (round.hasNext()) {
            round.next();
        }

        return cars;
    }

    private void moveAllCars() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        if (raceRule.canMove()) {
            car.move();
        }
    }

    public List<Car> getWinner() {
        if (round.hasNext()) {
            throw new IllegalArgumentException();
        }

        return raceRule.determineWinners(cars);
    }

    public boolean isGameEnd() {
        return !round.hasNext();
    }
}
