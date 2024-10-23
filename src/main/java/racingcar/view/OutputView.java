package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("실행결과");
    }

    public static void printRoundResult(Map<String, Integer> result) {
        List<String> names = new ArrayList<>(result.keySet());
        for (String name : names) {
            System.out.printf("%s : %s",name, printCountBar(result.get(name)));
            System.out.println();
        }
        System.out.println();
    }

    private static String printCountBar(Integer integer) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < integer; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printFinalResult(List<String> finalResult) {
        String result = String.join(",", finalResult);
        System.out.printf("최종 우승자 : %s", result);
    }
}
