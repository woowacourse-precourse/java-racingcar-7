package view;

import model.Car;

import java.util.List;

public class Output {

    public static void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
