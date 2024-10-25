package racingcar;

import static racingcar.TextFormat.RACING_GAME_RESULT;
import static racingcar.TextString.CAR_NAME_TEXT;
import static racingcar.TextString.NEW_LINE;
import static racingcar.TextString.RESULT_TEXT;
import static racingcar.TextString.TRY_COUNT_TEXT;

public class PrintOutputView {
    public void printRequireNames() {
        System.out.println(CAR_NAME_TEXT.getText());
    }

    public void printRequireTryCount() {
        System.out.println(TRY_COUNT_TEXT.getText());
    }

    public void printExecuteStart() {
        System.out.println(NEW_LINE.getText() + RESULT_TEXT.getText());
    }

    public void printExecuteResult(String racingCarTryResult) {
        System.out.println(racingCarTryResult);
    }


    public void printWinner(String racingGameWinners) {
        System.out.print(RACING_GAME_RESULT.format(racingGameWinners));
    }
}
