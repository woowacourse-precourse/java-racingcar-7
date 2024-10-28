package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void runSingleRound() {
        for (Car car : cars) {
            car.moveForwardByRandom();
        }
    }

    public List<Car> getWinners() {
        int maxForwardCount = getMaxForwardCount();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount() == maxForwardCount) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int getMaxForwardCount() {
        int maxForwardCount = 0;
        for (Car car : cars) {
            maxForwardCount = Math.max(maxForwardCount, car.getForwardCount());
        }
        return maxForwardCount;
    }
}
