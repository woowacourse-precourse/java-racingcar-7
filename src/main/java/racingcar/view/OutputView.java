package racingcar.view;

public class OutputView {
    public static void printInputNamesMessage() {
        System.out.println(SystemMessage.INPUT_NAMES.getMessage());
    }

    public static void printInputRoundMessage() {
        System.out.println(SystemMessage.INPUT_ROUND.getMessage());
    }

    public static void printFinalResultMessage() {
        printBlankLine();
        System.out.println(SystemMessage.FINAL_RESULT.getMessage());
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printCarNameAndMovingResult(String name, String result) {
        System.out.printf(SystemMessage.CAR_NAME_AND_MOVING_RESULT.getMessage(), name, result);
        printBlankLine();
    }

    public static void printFinalWinners(String winners) {
        System.out.printf(SystemMessage.FINAL_WINNERS.getMessage(), winners);
    }
}
