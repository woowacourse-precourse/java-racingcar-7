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
            compareOtherCars(lastRacingRecord, winnerNames, currentCar);
        }

        return winnerNames;
    }

    private static void compareOtherCars(List<Car> lastRacingRecord, List<String> winnerNames, Car currentCar) {
        for (Car otherCar : lastRacingRecord) {
            addWinner(winnerNames, currentCar, otherCar);
        }
    }

    private static void addWinner(List<String> winnerNames, Car currentCar, Car otherCar) {
        boolean isWinner = currentCar != otherCar && currentCar.isAheadOrEqual(otherCar);
        if (isWinner) {
            List<String> winnerDetails = Arrays.stream(currentCar.toCustomFormatString("-").split(" : "))
                    .toList();

            winnerNames.add(winnerDetails.get(0));
        }
    }
}
