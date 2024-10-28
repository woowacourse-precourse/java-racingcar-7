package racingcar.domain.winner.service;

import racingcar.domain.car.entity.Car;
import racingcar.domain.winner.entity.Winner;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {

    public Winner calculateWinner(List<Car> carList) {
        int maxLength = 0;
        List<Car> winners = new ArrayList<>();

        for (Car car : carList) {
            int roadLength = car.getRoad().getLength();

            // 새로운 최대 길이를 찾은 경우
            if (roadLength > maxLength) {
                maxLength = roadLength;
                winners.clear();
                winners.add(car);
            } else if (roadLength == maxLength) {
                winners.add(car); // 현재 길이가 최대와 같다면 우승자 리스트에 추가
            }
        }

        return new Winner(winners);
    }
}

