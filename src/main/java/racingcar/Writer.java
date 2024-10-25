package racingcar;

import java.util.List;

public class Writer {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRoundResult(List<Car> cars) {

        for (Car car : cars)
            printCarScore(car);

        System.out.println();
    }

    public static void printCarScore(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getScore(); i++)
            System.out.print("-");

        System.out.println("");
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (Car car : winners) {
            System.out.print(car.getName());
            System.out.print(", ");
        }
        System.out.println("\b\b ");
    }
}
