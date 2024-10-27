package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT_TITLE = "\n실행 결과";

    public void printExecutionResult(List<String> executionResult) {
        System.out.println(EXECUTION_RESULT_TITLE);
        executionResult.forEach(System.out::println);
    }
}
