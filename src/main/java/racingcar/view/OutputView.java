package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printRaceProgress(List<Car> cars) {
        System.out.println("\n실행 결과");
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
    }
}
