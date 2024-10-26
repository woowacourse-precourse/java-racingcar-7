package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : %s";
    private static final String WINNER_NAMES_DELIMITER = ", ";
    private static final String MOVE_EXPRESS = "-";
    private static final String CAR_POSITION_FORMAT = "%s : %s";

    private OutputView() {
    }


    public static void printRaceResult(Map<String, Integer> raceResult) {
        raceResult.forEach(OutputView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(String name, int distance) {
        String position = generateMoveExpression(distance);
        System.out.println(String.format(CAR_POSITION_FORMAT, name, position));
    }

    private static String generateMoveExpression(int distance) {
        return MOVE_EXPRESS.repeat(distance);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(WINNER_NAMES_DELIMITER, winners);
        System.out.printf(WINNER_ANNOUNCEMENT, winnerNames);
    }
}
