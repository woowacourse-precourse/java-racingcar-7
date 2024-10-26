package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.RoundRaceRecord;

public class OutputView {

    private static final String RACE_PROCESS_MESSAGE = "\n실행 결과";
    private static final String CAR_CURRENT_POSITION_MESSAGE = "%s : %s\n";
    private static final String WINNER_MASSAGE = "최종 우승자 : %s";
    private static final String SEPARATOR = ",";

    public void printRaceStart() {
        System.out.println(RACE_PROCESS_MESSAGE);
    }

    public void printRoundResult(List<RoundRaceRecord> roundResult) {
        for (RoundRaceRecord roundRaceRecord : roundResult) {
            System.out.printf(CAR_CURRENT_POSITION_MESSAGE, roundRaceRecord.name(), displayPosition(roundRaceRecord.position()));
        }
    }

    private String displayPosition(int position) {
        return "-".repeat(position);
    }

    public void printWinner(List<String> winnerCarNames) {
        if (winnerCarNames.size() == 1) {
            System.out.printf(WINNER_MASSAGE, winnerCarNames.getFirst());
            Console.close();
            return;
        }
        System.out.printf(WINNER_MASSAGE, String.join(SEPARATOR, winnerCarNames));
    }
}
