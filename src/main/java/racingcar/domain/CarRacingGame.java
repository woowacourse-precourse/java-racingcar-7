package racingcar.domain;

import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final NumberGenerator numberGenerator;
    private int rounds;

    public CarRacingGame(Cars cars, NumberGenerator numberGenerator, int rounds) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
        this.rounds = rounds;
    }

    public List<Car> start() {
        cars.move(numberGenerator);
        rounds--;
        return cars.getCarList();
    }

    public boolean canPlay() {
        return rounds > 0;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
