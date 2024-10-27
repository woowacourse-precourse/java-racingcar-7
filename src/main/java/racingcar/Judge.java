package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    List<Car> winners = new ArrayList<>();

    public List<Car> judge(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);

        addWinnerList(cars, maxDistance);

        return winners;
    }

    public int getMaxDistance(List<Car> cars) {
        int maxValue = 0;

        for (Car car : cars) {
            int distance = car.getDistance().length();
            if (distance > maxValue) {
                maxValue = distance;
            }
        }

        return maxValue;
    }

    public void addWinnerList(List<Car> cars, int maxDistance) {
        for (Car car : cars) {
            if (car.getDistance().length() == maxDistance) {
                winners.add(car);
            }
        }
    }

    public String getWinnerNames() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    public void show() {
        System.out.println("최종 우승자 : " + getWinnerNames());
    }
}
