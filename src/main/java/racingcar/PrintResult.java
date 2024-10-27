package racingcar;

import java.util.List;

public class PrintResult {

    public void printCar(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 1; i <= car.getForwardCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printCars(List<Car> cars, int attemptNumber) {

        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                printCar(car);
            }
        }

    }
}
