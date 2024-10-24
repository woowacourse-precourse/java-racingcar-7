package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    public List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxMovedNumber = -1;

        for (Car car : cars) {
            int movedNumber = car.getMovedNumber();
            if (movedNumber > maxMovedNumber) {
                maxMovedNumber = movedNumber;
                winners.clear();
                winners.add(car.getName());
            } else if (movedNumber == maxMovedNumber) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
