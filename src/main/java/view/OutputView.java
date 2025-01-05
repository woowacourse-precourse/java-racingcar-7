package view;

import java.util.List;
import racingcar.Car;
import racingcar.Racing;

public class OutputView {

    Racing racing = new Racing();

    public static void println(String message) {
        System.out.println(message);
    }

    public void printRacingResult(List<Car> cars, int attemptCount) {
        System.out.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            racing.playRacing(cars);
            for (Car car : cars) {
                car.printCarInfo();
            }
            System.out.println();
        }
    }

}
