package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

public abstract class RacingGameScoreBoard {

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printCurrentScore(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            System.out.print(car.getName() + " : ");
            System.out.println(getVisualDistance(car.getDistance()));
        }
        System.out.println();
    }

    private static String getVisualDistance(int distance) {
        return "-".repeat(Math.max(0, distance));
    }

    public static void printWinners(RacingCars racingCars) {
        System.out.print("최종 우승자 : ");
        System.out.println(racingCars);
    }
}
