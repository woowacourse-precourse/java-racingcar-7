package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GetWinner {
    public String findWinner(Car[] cars) {
        int winnerPosition = findWinnerPosition(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }

    private int findWinnerPosition(Car[] cars) {
        int winnerPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > winnerPosition) {
                winnerPosition = car.getPosition();
            }
        }
        return winnerPosition;
    }
}
