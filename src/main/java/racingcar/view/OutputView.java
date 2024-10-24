package racingcar.view;

public class OutputView {
    private static final String BLANK_LINE = "\n";

    public static void printInputNamesMessage() {
        System.out.println(SystemMessage.INPUT_NAMES.getMessage());
    }

    public static void printInputRoundMessage() {
        System.out.println(SystemMessage.INPUT_ROUND.getMessage());
    }

    public static void printFinalResultMessage() {
        System.out.println(BLANK_LINE + SystemMessage.FINAL_RESULT.getMessage());
    }
}
