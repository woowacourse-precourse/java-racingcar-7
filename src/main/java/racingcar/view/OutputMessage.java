package racingcar.view;

import racingcar.constants.GameConstants;
import racingcar.constants.MessageType;

public class OutputMessage {

    public static void executeResultMessage(String winner) {
        System.out.println(MessageType.RESPONSE_FINAL_WINNER.getMessage() + winner);
    }

    public static void resultMessage() {
        System.out.println(MessageType.RESPONSE_RESULT.getMessage());
    }

    public static void printHyphenMessage(String carName, int carMoveCount) {
        System.out.println(carName + " : " + GameConstants.HYPHEN.repeat(carMoveCount));
    }

}
