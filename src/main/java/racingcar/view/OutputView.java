package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class OutputView {

    private static final String WINNER_MASSAGE = "최종 우승자 : %s";
    private static final String SEPARATOR = ",";

    public void printWinner(List<String> winnerCarNames) {
        if (winnerCarNames.size() == 1) {
            System.out.printf(WINNER_MASSAGE, winnerCarNames.getFirst());
            Console.close();
            return;
        }
        System.out.printf(WINNER_MASSAGE, String.join(SEPARATOR, winnerCarNames));
    }
}
