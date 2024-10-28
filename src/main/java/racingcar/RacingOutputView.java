package racingcar;

import java.util.List;

public class RacingOutputView {
    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printDashes(car.getGoStop());
            System.out.println();
        }
        System.out.println();
    }

    private void printDashes(int count) {
        for (int i = 0 ; i < count ; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<Car> cars, int maxDistance) {
        System.out.print("최종 우승자 : ");
        boolean stop = true;
        for (Car car : cars) {
            if (car.getGoStop() == maxDistance) {
                printCarWinner(car, stop);
                stop = false;
            }
        }
        System.out.println();
    }

    private void printCarWinner(Car car, boolean stop) {
        if (!stop) {
            System.out.print(", ");
        }
        System.out.print(car.getName());
    }

}
