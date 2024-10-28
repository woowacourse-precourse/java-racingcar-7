package racingcar.view;

import racingcar.domain.RacingCar;

public class OutputView {
    public static void resultMessage(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        System.out.println("-".repeat(racingCar.getCount()));
    }

    public static void printWinner(String winner) {
        System.out.println(winner);
    }
}
