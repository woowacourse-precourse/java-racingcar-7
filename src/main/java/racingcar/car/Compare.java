package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    public int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            int position = car.getMoveHistory().length();
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    public List<String> winnerName(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = maxPosition(cars);
        for (Car car : cars) {
            if (car.getMoveHistory().length() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
