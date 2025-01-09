package racingcar;

import java.util.List;

public class Racing {

    private final Cars cars;
    private final int attemptCount;

    public Racing(List<Car> cars, int attemptCount) {
        this.cars = new Cars(cars);
        this.attemptCount = attemptCount;
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public void playRacing() {
        cars.playRacing();
    }

    public List<String> racingInfo() {
        return cars.getForwardInfos();
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
