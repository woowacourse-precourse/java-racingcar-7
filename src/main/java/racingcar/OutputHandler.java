package racingcar;

import java.util.List;

public class OutputHandler {
    public static void printCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + " : " + racingCar.getPositionWithDash());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
