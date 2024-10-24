package racingcar;

import java.util.List;

public class RacingOutputView {
    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0 ; i <car.getGoStop(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
