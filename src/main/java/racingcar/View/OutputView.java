package racingcar.View;

import static racingcar.View.ViewConstants.NAME_DELIMITER;
import static racingcar.View.ViewConstants.RACE_RESULT;
import static racingcar.View.ViewConstants.WHITE_SPACE;
import static racingcar.View.ViewConstants.WINNER_IS;

import java.util.List;

public class OutputView {
    public void printResultPhrase() {
        System.out.println(System.lineSeparator() + RACE_RESULT);
    }

    public void printRaceProgress(String roundResult) {
        System.out.println(roundResult);
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(NAME_DELIMITER + WHITE_SPACE, winnerNames);
        System.out.printf("%s%s", WINNER_IS, winners);
    }
}