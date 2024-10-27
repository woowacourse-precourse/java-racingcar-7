package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.MovementRecord;

public class OutputView {

    private static final String PROCESS_RESULT = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    private static final String WINNER_DELIMITER = ", ";
    private static final String PROCESS_POSITION_MARK = "-";

    public static void printProcess(MovementRecord movementRecord) {
        System.out.println(PROCESS_RESULT);

        for (Map<String, Integer> round : movementRecord.getRounds()) {
            printRoundResult(round);

            System.out.println();
        }
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(WINNER_DELIMITER, winners);

        System.out.println(WINNER_ANNOUNCEMENT + winnerNames);
    }

    private static void printRoundResult(Map<String, Integer> round) {
        for (Map.Entry<String, Integer> entry : round.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();

            String progress = PROCESS_POSITION_MARK.repeat(position);
            String result = String.format("%s : %s", carName, progress);

            System.out.println(result);
        }
    }

}
