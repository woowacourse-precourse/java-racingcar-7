package racingcar.view;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public void printPerAttempt(Map<String, String> carMoveMap) {
        for (Entry<String, String> items : carMoveMap.entrySet()) {
            String car = items.getKey();
            String move = items.getValue();
            System.out.println(car + " : " + move);
        }
    }

    public void printWinner(ArrayList<String> winners) {
        String winnerPrint = "최종 우승자 : " + String.join(",", winners);
        System.out.println(winnerPrint);
    }
}
