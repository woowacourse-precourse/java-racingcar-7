package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    public List<String> getWinners(List<Car> cars) {
        return findWinner(cars);
    }

    private List<String> findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
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
}