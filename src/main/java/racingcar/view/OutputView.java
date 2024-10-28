package racingcar.view;

import java.util.List;
import racingcar.entity.Car;
import racingcar.enums.Delimiter;
import racingcar.enums.NotificationMessage;

public class OutputView {
    public static void printExecutionResults() {
        System.out.println(Delimiter.NEW_LINE.getValue() + NotificationMessage.EXECUTION_RESULT.getMessage());
    }

    public static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + Delimiter.COLON.getValue() + car.getPositionDisplay());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print(
                NotificationMessage.FINAL_WINNERS.getMessage() +
                        Delimiter.COLON.getValue() +
                        String.join(Delimiter.COMMA.getValue() + " ", winners)
        );
    }
}
