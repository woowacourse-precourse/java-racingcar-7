package racingcar;

import java.util.List;

public class RacingGame {

    private final GoingValueGenerator goingValueGenerator;
    private final Cars cars;
    private final int round;
    private int currentRound = 0;

    public RacingGame(GoingValueGenerator goingValueGenerator, Cars cars, int round) {
        validateRound(round);
        this.goingValueGenerator = goingValueGenerator;
        this.cars = cars;
        this.round = round;
    }

    private void validateRound(int round) {
        if (round < 1 || round > 10000) {
            throw new IllegalArgumentException("자동차 경주 게임의 라운드는 1회 이상, 10,000회 이하여야 합니다.");
        }
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
