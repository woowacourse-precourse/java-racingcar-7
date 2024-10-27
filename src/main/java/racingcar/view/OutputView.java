package racingcar.view;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.global.Message.MOVE_FORWARD_RESULT;
import static racingcar.global.Message.WINNER;

import java.util.List;
import racingcar.domain.MoveForwardRecord;

public class OutputView {

    private static final String COLON = " : ";
    private static final String BAR = "-";

    public void printWinner(List<String> winners) {
        System.out.print(WINNER.getMessage());
        System.out.print(String.join(",", winners));
    }

    public void printMoveForwardResult() {
        System.out.println(MOVE_FORWARD_RESULT.getMessage());
    }

    public void printMoveForwardRecord(List<MoveForwardRecord> moveForwardRecords) {
        moveForwardRecords.stream()
                .forEach(record -> System.out.println(record.getCarName() + COLON + BAR.repeat(record.getGoCount())));
        System.out.println();
    }

    public void go(String tryCounts, List<MoveForwardRecord> moveForwardRecords) {
        printMoveForwardResult();

        for (int i = 0; i < Integer.parseInt(tryCounts); i++) {
            moveForwardRecords.stream()
                    .forEach(moveForwardRecord -> moveForwardRecord.updateGoCount(pickNumberInRange(0, 9)));
            printMoveForwardRecord(moveForwardRecords);
        }

    }
}
