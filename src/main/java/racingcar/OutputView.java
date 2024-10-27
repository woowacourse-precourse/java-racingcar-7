package racingcar;

import static racingcar.ViewConstants.RACE_DISPLAY_FORMAT;
import static racingcar.ViewConstants.MOVE_SYMBOL;
import static racingcar.ViewConstants.RACE_RESULT;
import static racingcar.ViewConstants.WINNER_IS;

import java.util.List;

public class OutputView {
    public void printResultPhrase() {
        System.out.println(System.lineSeparator() + RACE_RESULT);
    }

    public void printRaceResult(List<CurrentCar> currentCars) {
        for (CurrentCar currentCar : currentCars) {
            System.out.printf(RACE_DISPLAY_FORMAT, currentCar.carName());
            System.out.println(MOVE_SYMBOL.repeat(currentCar.moveCount()));
        }
        System.out.println();
    }

    public void printWinners(String winnerNames) {
        System.out.printf("%s%s", WINNER_IS, winnerNames);
    }
}
