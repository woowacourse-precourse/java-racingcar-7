package racingcar.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class RaceService {

    public String[] splitCarNames(String carNames) {
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public void decisionWinners(List<Car> Cars) {
        for (Car car : Cars) {

        }
    }

    public int getWinnerPosition(List<Car> Cars) {
        Car winner = Collections.max(Cars, Comparator.comparingInt(car -> car.getPosition()));
        int winnerPosition = winner.getPosition();
        return winnerPosition;
    }
}
