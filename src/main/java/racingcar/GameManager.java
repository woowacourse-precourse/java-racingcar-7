package racingcar;

import java.util.List;

public class GameManager {
    public static void gameStart(List<Car> cars, int tryCount) {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }

            printProgress(cars);
        }
    }

    private static void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
