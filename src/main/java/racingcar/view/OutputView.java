package racingcar.view;

import static racingcar.global.Message.MOVE_FORWARD_RESULT;
import static racingcar.global.Message.WINNER;

import java.util.List;
import racingcar.domain.MoveForwardRecord;

public class OutputView {

    private static final String COLON = " : ";
    private static final String BAR = "-";

    public static void printWinner(List<String> winners) {
        System.out.print(WINNER.getMessage());
        System.out.print(String.join(",", winners));
    }

    public static void printMoveForwardResult() {
        System.out.println(MOVE_FORWARD_RESULT.getMessage());
    }

    public static void printMoveForwardRecord(List<MoveForwardRecord> moveForwardRecords) {
        moveForwardRecords.stream()
                .forEach(record -> System.out.println(record.getCarName() + COLON + BAR.repeat(record.getGoCount())));
    }
}
