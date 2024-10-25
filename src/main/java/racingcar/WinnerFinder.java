package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    private List<String> winners = new ArrayList<>();

    public void findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        return winners;
    }
}