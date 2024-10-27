package racingcar.racing;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public int findMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition(); // 가장 멀리 간 자동차의 위치 업데이트
            }
        }
        return maxPosition;
    }

    public List<String> findWinners(Car[] cars){
        int maxPosition = findMaxPosition(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName()); // 우승자의 이름 추가
            }
        }

        return winners;
    }
}
