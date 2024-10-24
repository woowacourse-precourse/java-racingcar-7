package racingcar.view;

public class OutputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : %s";

    public static void printCarNamesInputMessage() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printAttemptCountInputMessage() {
        System.out.println(INPUT_ATTEMPT_COUNT);
    }

    public static void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printFinalWinner() {
        System.out.println(FINAL_WINNER);
    }
}
