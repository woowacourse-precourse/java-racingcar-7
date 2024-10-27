package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printExecutionResult(Map<String, Integer> car, String[] carName) {
        for (int i = 0; i < carName.length; i++) {
            System.out.println(carName[i] + " : " + "-".repeat(car.get(carName[i])));
        }
        System.out.println();
    }

    public void printWinner(Map<String, Integer> car) {
        List<String> winnerList = new ArrayList<>();
        int winnerScore = Collections.max(car.values());
        for (String key : car.keySet()) {
            if (car.get(key) == winnerScore) {
                winnerList.add(key);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

}
