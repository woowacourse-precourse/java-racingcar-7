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

    public void printWinner(List<Car> cars, int maxDistance) {
        System.out.print("최종 우승자 : ");
        boolean stop = true;
        for (Car car : cars) {
            if (car.getGoStop() == maxDistance) {
                if (!stop) {
                    System.out.print(", ");
                }
                System.out.print(car.getName());
                stop = false;
            }
        }
        System.out.println();
    }

}
