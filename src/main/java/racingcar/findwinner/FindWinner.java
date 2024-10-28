package racingcar.findwinner;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    public static String findWinner(List<Car> cars) {
        List<String> winnersList = new ArrayList<>();
        int maxDistance = 0;

        // 최대 거리 찾기
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance().length());
        }
        // 최대 거리를 가진 자동차 찾기
        for (Car car : cars) {
            if (car.getDistance().length() == maxDistance) {
                winnersList.add(car.getName());
            }
        }
        return String.join(", ", winnersList);
    }
}
