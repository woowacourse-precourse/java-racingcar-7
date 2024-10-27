package racingcar;

import java.util.List;
import racingcar.dto.PlayerStat;
import racingcar.dto.RoundResult;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public void printRoundResults(List<RoundResult> roundResults) {
        System.out.print("실행 결과");
        System.out.print(LINE_SEPARATOR);
        for (RoundResult roundResult : roundResults) {
            printRoundResult(roundResult);
        }
        System.out.print(LINE_SEPARATOR);
    }

    private void printRoundResult(RoundResult roundResult) {
        for (PlayerStat playerStat : roundResult.getPlayerStats()) {
            System.out.print(playerStat.getCarName() + " : " + "-".repeat(playerStat.getPosition()));
            System.out.print(LINE_SEPARATOR);
        }
        System.out.print(LINE_SEPARATOR);
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }
}
