package racingcar.view;

import java.util.List;

public class OutputView {
    public static void racingcarOutputView(List<String> carsLocation) {
        for (String oneCarLocation : carsLocation) {
            System.out.println(oneCarLocation);
        }
    }

    public static void printWinner(List<String> winners) {
        for(String winner : winners) {
            System.out.println(winner);
        }
    }
}
