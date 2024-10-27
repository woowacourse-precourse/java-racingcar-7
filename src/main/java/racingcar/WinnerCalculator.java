package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerCalculator {

    private WinnerCalculator() {
    }

    public static List<String> calculateWinners(List<Car> lastRacingRecord) {
        List<String> winnerNames = new ArrayList<>();
        for (Car currentCar : lastRacingRecord) {
            compareOtherCars(lastRacingRecord, currentCar);
            addIfWinner(lastRacingRecord, winnerNames, currentCar);
        }

        return winnerNames;
    }

    private static boolean compareOtherCars(List<Car> lastRacingRecord, Car currentCar) {
        for (Car otherCar : lastRacingRecord) {
            boolean isNotWinner = currentCar != otherCar && !(currentCar.isAheadOrEqual(otherCar));
            if (isNotWinner) {
                return false;
            }
        }

        return true;
    }

    private static void addIfWinner(List<Car> lastRacingRecord, List<String> winnerNames, Car currentCar) {
        if (compareOtherCars(lastRacingRecord, currentCar)) {
            List<String> winnerDetails = Arrays.stream(currentCar.toCustomFormatString("-").split(" : "))
                    .toList();

            winnerNames.add(winnerDetails.get(0));
        }
    }
}
