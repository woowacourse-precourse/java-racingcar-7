package racingcar.view;

public class OutputView {

    private static String FINAL_WINNER = "최종 우승자 : ";
    private static String OUTPUT_DELIMITER = ", ";

    public static void printFinalWinner() {
        System.out.print(FINAL_WINNER);
    }

    public static void printDelimiter() {
        System.out.print(OUTPUT_DELIMITER);
    }

}
