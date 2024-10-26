package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RaceJudge {
    public List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        //cars 리스트에서 위치 상태를 기준으로 내림차순 정렬
        Collections.sort(cars, Comparator.comparingInt(Car::getPosition).reversed());
        int maxPosition = cars.get(0).getPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
