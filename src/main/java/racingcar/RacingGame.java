package racingcar;

import java.util.List;

public class RacingGame {

    private final GoingValueGenerator goingValueGenerator;
    private final Cars cars;
    private final int round;
    private int currentRound = 0;

    public RacingGame(GoingValueGenerator goingValueGenerator, Cars cars, int round) {
        this.goingValueGenerator = goingValueGenerator;
        this.cars = cars;
        this.round = round;
    }

    public void progress() {
        cars.ongoingAllCars(goingValueGenerator);
        currentRound ++;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
