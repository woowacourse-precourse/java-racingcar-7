package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {

    private WinnerCalculator() {
    }

    public static List<String> calculateWinners(List<Car> lastRacingRecord) {
        List<String> winners = new ArrayList<>();

        int max = calculateMaxPosition(lastRacingRecord);
        for (Car car : lastRacingRecord) {
            winners.addAll(car.addIfWinner(max));
        }

        return winners;
    }

    public static int calculateMaxPosition(List<Car> lastRacingRecord) {
        int max = Integer.MIN_VALUE;
        for (Car lastRacingRecordCar : lastRacingRecord) {
            max = lastRacingRecordCar.calculateMaxPosition(max);
        }

        return max;
    }
}
