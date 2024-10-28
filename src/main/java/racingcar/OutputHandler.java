package racingcar;

import java.util.HashMap;
import java.util.List;

public class OutputHandler {
    public static void printRoundResult(HashMap<String, Integer> state) {
        for (String carName : state.keySet()) {
            System.out.print(carName + " : ");
            printPosition(state.get(carName));
        }
        System.out.println();
    }

    private static void printPosition(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_SYMBOL);
        }
        System.out.println();
    }

    public static void printFinalWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }

    private static final String POSITION_SYMBOL = "-";
    private static final String WINNER_MESSAGE = "최종 우승자: ";
}
