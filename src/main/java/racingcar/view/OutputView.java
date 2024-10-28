package racingcar.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static void progressResults(int round, List<String> carNames, HashMap<String, Integer> carPositions) {
        if (round == 0) {
            System.out.println("");
            System.out.println("실행 결과");
        }

        for (String carName : carNames) {
            System.out.println(carName + " : " + "-".repeat(carPositions.get(carName)));
        }

        System.out.println("");
    }

    public static void finalResult(List<String> winners) {
        String result = "최종 우승자 : ";

        if (winners.size() == 1) {
            result += winners.get(0);
        } else {
            result += String.join(", ", winners);
        }

        System.out.println(result);
    }
}
