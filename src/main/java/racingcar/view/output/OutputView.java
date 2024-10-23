package racingcar.view.output;

import java.util.List;

import static java.lang.String.format;
import static racingcar.constants.OutputMessages.FINAL_RESULT;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printRound(List<String> roundResults) {
        for (String roundResult : roundResults) {
            System.out.println(roundResult);
        }
    }

    public void printWinners(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        String finalResultFormat = format(FINAL_RESULT, winners);
        System.out.println(finalResultFormat);
    }
}
