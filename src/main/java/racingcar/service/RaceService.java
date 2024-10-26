package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class RaceService {

    public String[] splitCarNames(String carNames) {
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public List<String> decisionWinners(List<Car> Cars) {
        List<String> winners = new ArrayList<>();
        int winnerPosition = getWinnerPosition(Cars);
        for (Car car : Cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getWinnerPosition(List<Car> Cars) {
        Car winner = Collections.max(Cars, Comparator.comparingInt(car -> car.getPosition()));
        int winnerPosition = winner.getPosition();
        return winnerPosition;
    }
}
