package racingcar.view;

public class OutputView {
    private static final String INPUT_CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String ROAD_EXPRESSION = "-";
    private static final String CAR_NAME_SCORE_DELIMITER = ":";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void printCarNameGuide() {
        System.out.println(INPUT_CAR_NAME_GUIDE);
    }

    public static void printRaceCountGuide() {
        System.out.println(INPUT_RACE_COUNT_GUIDE);
    }

    public static void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }
}
