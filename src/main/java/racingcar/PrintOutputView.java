package racingcar;

import static racingcar.TextString.CAR_NAME_TEXT;
import static racingcar.TextString.FINAL_WINNERS_TEXT;
import static racingcar.TextString.NEW_LINE;
import static racingcar.TextString.RESULT_TEXT;
import static racingcar.TextString.TRY_COUNT_TEXT;

public class PrintOutputView {
    public void printRequireNames() {
        System.out.println(CAR_NAME_TEXT.getValue());
    }

    public void printRequireTryCount() {
        System.out.println(TRY_COUNT_TEXT.getValue());
    }

    public void printExecuteStart() {
        System.out.println(NEW_LINE + RESULT_TEXT.getValue());
    }

    public void printExecuteResult(String racingCarTryResult) {
        System.out.println(racingCarTryResult);
    }


    public void printWinner() {
        System.out.print(FINAL_WINNERS_TEXT);
    }
}
