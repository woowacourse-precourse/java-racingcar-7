package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    public String winnersMember(List<Car> cars) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getLocation() > maxDistance) {
                maxDistance = car.getLocation();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getLocation() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }
}