package racingcar;

import java.util.ArrayList;

import static racingcar.Constants.WINNER_NOTICE;
import static racingcar.Utils.println;

public class FinishRace {
    protected ArrayList<String> determineWinner(final ArrayList<Car> cars) {
        int maxMovedAmount = 0;
        ArrayList<Car> candidateCars = new ArrayList<>();

        // 참가 자동차 배열을 순회하면서 movedAmount가 가장 큰 자동차 저장
        for (Car car : cars) {
            if (car.movedAmount > maxMovedAmount) {
                maxMovedAmount = car.movedAmount;
                candidateCars.clear();
            } else if (car.movedAmount < maxMovedAmount) {
                continue;
            }
            candidateCars.add(car);
        }

        return getWinnerNames(candidateCars);
    }

    private ArrayList<String> getWinnerNames(final ArrayList<Car> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();

        winners.forEach(car -> winnerNames.add(car.name));

        return winnerNames;
    }

    protected void printGameWinners(final ArrayList<String> winners) {
        println(WINNER_NOTICE + String.join(", ", winners));
    }
}
