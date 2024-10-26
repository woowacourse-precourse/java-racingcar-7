package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceCarPrinter {
    public void printWinner(ArrayList<String> winner) {
        StringBuilder message = new StringBuilder("최종 우승자 : ");
        if (winner.size() == 1) {
            message.append(winner.get(0));
            System.out.println(message);
        } else {
            String winners = String.join(", ", winner);
            message.append(winners);
            System.out.println(message);
        }
    }

    public void printRace(HashMap<String, Integer> carMap) {
        StringBuilder message = new StringBuilder();
        for (String key : carMap.keySet()) {
            message.append(key)
                    .append(" : ")
                    .append("-".repeat(carMap.get(key)))
                    .append("\n");
        }
        System.out.println(message);
    }
}
