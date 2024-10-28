package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printRecord(List<Map<String, Integer>> record) {
        String car;
        String move;

        System.out.println("실행 결과");
        for (Map<String, Integer> cars: record) {
            for (Map.Entry<String, Integer> e: cars.entrySet()) {
                car = e.getKey();
                move = "-".repeat(e.getValue());
                System.out.println(car + " : " + move);
            }
            System.out.println();
        }
    }

    public void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }

}
