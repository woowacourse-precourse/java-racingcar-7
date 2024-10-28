package racingcar.interfaces.output;

public class OutputHandler {

    private static final String RESULT_HEADER = "실행 결과";

    public void print(String str) {
        System.out.println(str);
    }

    public void printResultHeader() {
        println();
        System.out.println(RESULT_HEADER);
    }

    public void println() {
        System.out.println();
    }
}
