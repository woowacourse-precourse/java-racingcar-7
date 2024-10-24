package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String POSITION_MARKER = "-";

    public static void printRoundResult(List<Car> cars) {
        System.out.println("실행 결과");
        cars.forEach(OutputView::printCarPosition);
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : " + POSITION_MARKER.repeat(car.getPosition()));
        System.out.println();
    }
}
