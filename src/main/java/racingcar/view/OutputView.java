package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static void printProgress(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        int numberOfWinners = winners.size();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < numberOfWinners - 1; i++) {
            System.out.print(winners.get(i).getName() + ", ");
        }
        System.out.println(winners.get(numberOfWinners - 1).getName());
    }
}
