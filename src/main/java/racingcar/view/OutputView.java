package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printCarStatus(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printExecutionResult() {
        System.out.println("\n실행 결과");
    }
}
