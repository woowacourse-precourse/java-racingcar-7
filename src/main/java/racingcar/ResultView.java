package racingcar;

import java.util.*;

public class ResultView {
    public static void printPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            if (car.getPosition() > 0) {
                System.out.println("-".repeat(car.getPosition()));
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void announceWinners(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
