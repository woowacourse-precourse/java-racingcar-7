package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerDecider {
    private Car[] cars;

    public WinnerDecider(Car[] cars) {
        this.cars = cars;
    }

    public String decideWinner() {
        int maxForwardCount = 0;
        for (Car car : cars) {
            if (car.getForwardCount() > maxForwardCount) {
                maxForwardCount = car.getForwardCount();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount() == maxForwardCount) {
                winners.add(car.getName());
            }
        }
        if (winners.size() == 1) {
            return winners.getFirst();
        } else {
            return String.join(", ", winners);
        }
    }
}
