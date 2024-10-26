package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceCarPrinter {
    public void printWinner(ArrayList<String> winner) {
        StringBuilder message = new StringBuilder("최종 우승자 : ");
        message.append(String.join(", ",winner));
        System.out.println(message);
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
