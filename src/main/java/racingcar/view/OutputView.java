package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public static void printWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }

    public static void printCarsPostions(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
