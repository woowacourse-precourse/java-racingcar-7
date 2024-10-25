package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private final class OutputViewConstant {
        public static final String COUNT_BAR = "-";
        public static final String COMMA_SPACE = ", ";
        public static final String RESULT_MESSAGE = "실행결과";
        public static final String ROUND_RESULT_FORMAT = "%s : %s%n";
        public static final String WINNER_FORMAT = "%s : %s%n";
    }

    public static void printResultMessage() {
        System.out.println(OutputViewConstant.RESULT_MESSAGE);
    }

    public static void printRoundResult(Map<String, Integer> result) {
        result.forEach((name, position) -> {
            System.out.printf(OutputViewConstant.ROUND_RESULT_FORMAT
                ,name
                ,drawCountBar(result.get(name)));
        });
        System.out.println();
    }

    private static String drawCountBar(Integer goCount) {
        return OutputViewConstant.COUNT_BAR.repeat(goCount);
    }

    public static void printFinalResult(List<String> finalResult) {
        String result = String.join(OutputViewConstant.COMMA_SPACE, finalResult);
        System.out.printf(OutputViewConstant.WINNER_FORMAT, result);
    }
}
