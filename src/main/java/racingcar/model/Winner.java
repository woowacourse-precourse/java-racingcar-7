package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public String getWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = collectWinners(cars, maxPosition);
        return String.join(", ", winners);
    }

    //가장 앞에 있는 자동차의 위치를 찾는다.
    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    //가장 앞에 있는 자동차들의 이름을 찾는다.
    private List<String> collectWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
