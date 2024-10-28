package racingcar.view;

import java.util.List;
import racingcar.Racingcar;

public class WinnerView {
    public static void showWinners(List<Racingcar> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Racingcar::getName).toArray(String[]::new));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
