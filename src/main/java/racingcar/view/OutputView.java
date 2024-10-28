package racingcar.view;

import racingcar.message.Message;
import racingcar.model.RacingCars;
public class OutputView {
    public static void printExecutionMessage() {
        System.out.println();
        System.out.print(Message.EXECUTION_MESSAGE);
    }
    public static void printRoundResult(RacingCars racingCars) {
        System.out.println(racingCars);
    }
    public static void printWinners(RacingCars racingCars) {
        System.out.print(Message.WINNER_MESSAGE);
        System.out.println(racingCars.getWinners());
    }
}
