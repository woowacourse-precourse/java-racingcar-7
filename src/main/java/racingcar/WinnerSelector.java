package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {

    public static List<String> calculateWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            int score = car.getScore();

            if (score > max) {
                max = score;
                winners.clear();
                winners.add(car.getCarName());
                continue;
            }

            if (score == max) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
