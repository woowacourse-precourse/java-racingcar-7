package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {

    public static List<String> selectWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                winners.clear();
                winners.add(car.getName());
                maxPosition = car.getPosition();
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}