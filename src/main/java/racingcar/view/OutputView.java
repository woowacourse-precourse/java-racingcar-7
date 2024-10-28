package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public static void printRaceStatusHeader() {
        System.out.println("\n실행결과");
    }

    public static void printRaceStatus(Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(car.getDistance());
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
