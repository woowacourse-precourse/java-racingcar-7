package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static int findMaxDistance(List<Car> cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            if (maxDistance < car.distance) {
                maxDistance = car.distance;
            }
        }
        return maxDistance;
    }

    public static List<Car> find(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.distance) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static String makeList(List<Car> winners) {
        String winnerList = "";

        int i = 0;

        for (Car car : winners) {
            winnerList += car.name;
            if (i < winners.size() - 1) {
                winnerList += ", ";
            }
            i++;
        }
        return winnerList;
    }
}
