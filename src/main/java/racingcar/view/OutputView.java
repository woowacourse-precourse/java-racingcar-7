package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String EXECUTION_RESULT_TITLE = "\n실행 결과";
    private static final String TOTAL_RESULT_PREFIX = "\n최종 우승자 : ";

    public void printExecutionResult(List<String> executionResult) {
        System.out.println(EXECUTION_RESULT_TITLE);
        executionResult.forEach(System.out::println);
    }

    public void printTotalResult(List<String> totalResult) {
        String result = TOTAL_RESULT_PREFIX + String.join(DELIMITER, totalResult);
        System.out.println(result);
    }
}
