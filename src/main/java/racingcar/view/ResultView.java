package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ResultView {

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.println("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
