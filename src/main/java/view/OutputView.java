package view;

import java.util.List;
import racingcar.Racing;

public class OutputView {

    public static void println(String message) {
        System.out.println(message);
    }

    public void printRacingResult(Racing racing) {
        racing.printAllRacingResult();
    }

    public void printFinalWinners(Racing racing) {
        List<String> winners = racing.findWinners();
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }

}
