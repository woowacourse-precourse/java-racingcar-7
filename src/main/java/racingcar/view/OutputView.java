package racingcar.view;

import racingcar.util.IOMessage;

public class OutputView {
    public void printRaceProcedure(String name, String bar) {
        // String distanceBar = drewBar(distance);
        System.out.println(name + " : " + bar);
    }

    public void printWinner(String winners) {
        System.out.println(IOMessage.OUTPUT_RESULT_MESSAGE.getMessage() + winners);
    }
}
