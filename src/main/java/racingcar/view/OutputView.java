package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class OutputView {
    public static void printRoundStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getPositionRepresentation()));
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
