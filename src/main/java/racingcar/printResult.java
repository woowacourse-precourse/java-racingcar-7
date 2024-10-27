package racingcar;

import java.util.List;

public class printResult {

    public void printCar(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 1; i <= car.getForwardCount(); i++) {
            System.out.print("-");
        }
    }

    public void printCars(List<Car> cars, int attemptNumber) {
        System.out.println("실행 결과");

        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                printCar(car);
            }
        }

    }
}
