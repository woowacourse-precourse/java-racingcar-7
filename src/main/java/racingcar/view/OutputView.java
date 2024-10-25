package racingcar.view;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private OutputView() {
    }

    public static void printCarNameInputPrompt() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printNumberOfAttemptCountMessage() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }
}
