package racingcar;

import java.util.List;

public class OutputConsole {
    public static void outputExecutionResult(String carName, Integer forwardDistance) {
        System.out.println(carName + " : " + "-".repeat(forwardDistance));
    }

    public static void outputWinnerResult(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    public static void changeLine() {
        System.out.println();
    }
}
