package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class WinnerCalculator {
    public String determineWinners(List<Car> cars) {
        int maxScore = 0;
        List<String> winners = new ArrayList<String>();

        for (Car car : cars) {
            int score = car.getGameTotalScore();
            if (score > maxScore) {
                maxScore = score;
                winners.clear();
                winners.add(car.getCarName());
            } else if (score == maxScore) {
                winners.add(car.getCarName());
            }
        }
        return String.join(", ", winners);
    }
}