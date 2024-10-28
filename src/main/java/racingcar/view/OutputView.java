package racingcar.view;

import racingcar.util.IOMessage;

public class OutputView {
    public void printRaceProcedure(String name, String bar) {
        System.out.println(name + " : " + bar);
    }

    public void printWinnerNames(String winners) {
        System.out.println(IOMessage.OUTPUT_RESULT_MESSAGE.getMessage() + winners);
    }
}
