package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String COUNT_BAR = "-";
    public static final String COMMA = ",";

    public static void printResultMessage() {
        System.out.println("실행결과");
    }

    public static void printRoundResult(Map<String, Integer> result) {
        result.forEach((name, position) -> {
            System.out.printf("%s : %s%n",name, drawCountBar(result.get(name)));
        });
        System.out.println();
    }

    private static String drawCountBar(Integer goCount) {
        return COUNT_BAR.repeat(goCount);
    }

    public static void printFinalResult(List<String> finalResult) {
        String result = String.join(COMMA, finalResult);
        System.out.printf("최종 우승자 : %s", result);
    }
}
