package racingcar.domain;

import java.util.List;

public class Race {
    private final Round round;
    private final List<Car> cars;
    private final RaceRule raceRule;

    public Race(int totalRound, List<String> names, RaceRule raceRule) {
        RaceRule.validateNames(names);
        this.round = new Round(totalRound);
        this.cars = cars(names);
        this.raceRule = raceRule;
    }

    public List<Car> proceed() {
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

        return RaceRule.findWinners(cars);
    }

    public boolean isGameEnd() {
        return !round.hasNext();
    }

    public List<Car> cars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }
}
