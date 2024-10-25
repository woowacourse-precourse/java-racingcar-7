package racingcar.view;

import racingcar.model.Car;

public class RacingView {
    public static void tryResult(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getMovingDisplay());
        }
    }

    public static void racingResult(Car[] winners, int winnerCount) {
        System.out.print("최종우승자 : ");
        for (int i = 0; i < winnerCount; i++) {
            System.out.print(winners[i].getName());
            if (i < winnerCount - 1) {
                System.out.print(", ");
            }
        }
    }
}
