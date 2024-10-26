package racingcar.view;

public class OutputView {
    private static final String GAME_START_OUTPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_OF_ATTEMPTS_OUTPUT = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_OUTPUT = "실행 결과";
    private static final String BETWEEN_NAME_AND_POSITION = " : ";
    private static final String POSITION_COUNT_PREFIX = "-";
    private static final String WINNER_OUTPUT = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String NEXT_LINE = "\n";

    public static void renderFirstRun() {
        System.out.println(GAME_START_OUTPUT);
    }

    public static void renderAttemptCountInput() {
        System.out.println(COUNT_OF_ATTEMPTS_OUTPUT);
    }

}
