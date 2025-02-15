package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    public static void printError(String message) {
        System.out.println("Error: " + message);
    }
}
