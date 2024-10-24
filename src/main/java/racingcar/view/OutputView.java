package racingcar.view;

public class OutputView {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String NAME_DISTANCE_SEPARATOR = " : ";
    private static final String HYPHEN = "-";

    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printGameResult(String name, int movedDistance) {
        printName(name);
        printSeparator();
        convertDistanceToHyphen(movedDistance);
        printEmptyLine();
    }

    public void printEmptyLine() {
        System.out.println();
    }

    private void printName(String name) {
        System.out.print(name);
    }

    private void printSeparator() {
        System.out.print(NAME_DISTANCE_SEPARATOR);
    }

    private void convertDistanceToHyphen(int movedDistance) {
        for (int i = 0; i < movedDistance; i++) {
            System.out.print(HYPHEN);
        }
    }


}
