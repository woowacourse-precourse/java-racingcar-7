package racingcar.racing;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> findWinners(List<Car> cars){
        int maxPosition = findMaxPosition(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
