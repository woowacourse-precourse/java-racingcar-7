package racingcar.view;

import static racingcar.global.Message.MOVE_FORWARD_RESULT;
import static racingcar.global.Message.WINNER;

import java.util.List;

public class OutputView {

    public static void printWinner(List<String> winners) {
        System.out.print(WINNER.getMessage() + " ");
        System.out.print(String.join(",", winners));
    }

    public static void printMoveForwardResult() {
        System.out.println(MOVE_FORWARD_RESULT.getMessage());
    }
}
