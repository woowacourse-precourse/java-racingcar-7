package racingcar;

public class OutputView {

    public static final String OUTPUT_FILTER = "최종 우승자 : %s";
    public static void printOutput(String format, String[] output) {
        System.out.printf(format, String.join(", ", output));
    }
}
