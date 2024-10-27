package racingcar.view;

import racingcar.domain.Race;
import racingcar.domain.GameResult;
import racingcar.domain.RacingHistory;

import java.util.List;

public class OutputView {
    private static final String EXECUTE_RESULT = "\n실행 결과\n";
    private static final String NAME_DELIMITER = " : ";
    private static final String DISTANCE_MARK = "-";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public static void print(List<RacingHistory> histories, Race race) {
        StringBuilder sb = new StringBuilder();
        sb.append(EXECUTE_RESULT);
        sb.append(getRoundResult(histories, race));
        sb.append(getWinnerResult(histories));
        System.out.println(sb);
    }

    private static String getRoundResult(List<RacingHistory> histories, Race race) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < histories.size(); i++) {
            RacingHistory history = histories.get(i);
            sb.append(history.getName()).append(NAME_DELIMITER).append(DISTANCE_MARK.repeat(history.getDistance())).append("\n");

            if ((i + 1) % race.getCarCount() == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String getWinnerResult(List<RacingHistory> histories) {
        StringBuilder sb = new StringBuilder();
        List<String> winners = GameResult.findWinners(histories);

        sb.append(WINNER_PREFIX);
        for (String winner : winners) {
            sb.append(winner);

            if (!winners.getLast().equals(winner)) {
                sb.append(WINNER_DELIMITER);
            }
        }
        return sb.toString();
    }
}
