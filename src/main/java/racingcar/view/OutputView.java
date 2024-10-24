package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getCount());
        }
        System.out.println();
    }
}
