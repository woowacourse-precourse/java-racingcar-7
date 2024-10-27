package racingcar.view;

import java.util.List;

public class OutputView {
    public static void racingcarOutputView(List<String> carsLocation) {
        for (String oneCarLocation : carsLocation) {
            System.out.println(oneCarLocation);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String winnerText="최종 우승자 : "+String.join(", ", winners);
        System.out.println(winnerText);
    }
}
