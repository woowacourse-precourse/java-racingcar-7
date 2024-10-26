package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printCarNameInputPrompt() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printNumberOfAttemptCountMessage() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    public void printExecutionResultPrompt() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printRoundProgress(List<String> formattedProgress) {
        formattedProgress.forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(String formattedWinners) {
        System.out.println(formattedWinners);
    }
}
