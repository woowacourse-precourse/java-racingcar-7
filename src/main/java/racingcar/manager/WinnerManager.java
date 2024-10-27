package racingcar.manager;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinnerManager {

    public List<String> whoWin(Set<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = updateWinners(car, winners, maxPosition);
        }

        return winners;
    }

    private int updateWinners(Car car, List<String> winners, int maxPosition) {
        if (car.getPosition() > maxPosition) {
            winners.clear();
            winners.add(car.getName());
            return car.getPosition();
        }

        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }

        return maxPosition;
    }
}
