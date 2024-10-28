package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class OutputView {
    public static void displayRoundResults(List<Car> cars) {
        cars.forEach(OutputView::printCarStatus);
        System.out.println();
    }

    private static void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionAsDashes());
    }

    public static void displayWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
