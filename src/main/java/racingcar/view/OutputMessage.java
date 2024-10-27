package racingcar.view;

public class OutputMessage {

    private static final String HYPHEN = "-";

    public static void executeResultMessage(String winner) {
        System.out.println(MessageType.RESPONSE_FINAL_WINNER.getMessage() + winner);
    }

    public static void resultMessage() {
        System.out.println(MessageType.RESPONSE_RESULT.getMessage());
    }

    public static void resultHyphenMessage(String carName, int carMoveCount) {
        System.out.println(carName + " : " + HYPHEN.repeat(carMoveCount));
    }
}
