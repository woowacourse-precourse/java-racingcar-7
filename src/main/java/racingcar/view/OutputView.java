package racingcar.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputView {

    public void outputCarMoves(LinkedHashMap<String, Integer> carMoves) {
        for (Map.Entry<String, Integer> m : carMoves.entrySet()) {
            System.out.println(m.getKey() + " : " + "-".repeat(m.getValue()));
        }
    }

    public void outputWinner(ArrayList<String> winners) {
        System.out.println(String.join(", ", winners));
    }
}
