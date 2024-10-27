package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printResult(Map<String, String> cars) {
        for (String key : cars.keySet()) {
            System.out.println(key + " : " + cars.get(key));
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        if (winner.size() == 1) {
            System.out.println("최종 우승자 : " + winner.getFirst());
            return;
        }
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
