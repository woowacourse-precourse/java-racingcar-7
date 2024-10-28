package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public static void printProgress(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        int numberOfWinners = winners.size();

        System.out.print(WINNER_MESSAGE);
        for (int i = 0; i < numberOfWinners - 1; i++) {
            System.out.print(winners.get(i).getName() + WINNER_DELIMITER);
        }
        System.out.println(winners.get(numberOfWinners - 1).getName());
    }
}
