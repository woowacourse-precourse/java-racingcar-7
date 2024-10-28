package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.print(WINNER_MESSAGE + winnerNames);
    }

    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCurrentStateFormat());
        }
        System.out.println();
    }
}