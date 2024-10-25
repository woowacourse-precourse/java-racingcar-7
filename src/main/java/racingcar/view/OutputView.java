package racingcar.view;

import java.util.List;
import racingcar.utils.Constants;

public class OutputView {
    public void printRaceMessage(List<String> raceInfos) {
        System.out.println(Constants.OUTPUT_RESULT_MESSAGE);
        raceInfos.forEach(raceInfo -> System.out.println(raceInfo));
        System.out.println();
    }

    public void printWinnerMessage(String winner) {
        System.out.print(Constants.OUTPUT_WINNER_MESSAGE);
        System.out.println(winner);
    }
}
