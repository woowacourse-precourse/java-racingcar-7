package racingcar;

import java.util.List;
import java.util.Map;

public class OutputHandler {

    public void printRaceState(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            System.out.print(car.getKey() + " : ");
            printMoveDistInBar(car.getValue());
            System.out.println();
        }
        System.out.println();
    }

    public void printRaceWinner(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
            else {
                System.out.println();
            }
        }
    }

    private void printMoveDistInBar(int dist) {
        while (dist-- > 0) {
            System.out.print("-");
        }
    }
}
