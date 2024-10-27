package racingcar.view;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COIN_INSERT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String SCORE = "-";
    private static final String COLON_DELIMITER = " : ";

    public static void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void printCoinInsertMessage() {
        System.out.println(COIN_INSERT_MESSAGE);
    }

    public static void printExecuteResultMessage() {
        System.out.println();
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public static void printRoundResultMessage(String name, int count) {
        String location = SCORE.repeat(count);
        System.out.println(name + COLON_DELIMITER + location);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinner(String winners) {
        System.out.println(WINNERS_MESSAGE + winners);
    }
}
