package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.Config;
import racingcar.util.Message;

public class OutputView {
    public void printExecutionResult() {
        System.out.println();
        System.out.println(Message.EXECUTION_RESULT);
    }

    public void printCurrentRoundRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(
                    car.getName() + Config.NAME_POSITION_SEPARATOR + Config.POSITION_SYMBOL.repeat(
                            car.getForwardCount()));
        }
        System.out.println();
    }

    public void printFinalRacingResult(List<String> winnerNames) {
        System.out.print(Message.FINAL_WINNER + String.join(Config.WINNER_SEPARATOR, winnerNames));
    }

}
