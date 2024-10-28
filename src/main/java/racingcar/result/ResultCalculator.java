package racingcar.result;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;

public class ResultCalculator {

    public List<String> determineWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findWinnersWithMaxPosition(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findWinnersWithMaxPosition(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
