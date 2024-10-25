package racingcar.racing.view;

import java.util.List;
import racingcar.racing.model.Car;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printRoundCar(car);
        }
        System.out.println();
    }

    private static void printRoundCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getTotalDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
