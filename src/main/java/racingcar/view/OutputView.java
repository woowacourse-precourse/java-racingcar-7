package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingGame;

public class OutputView {
    public static void printRoundResult(RacingGame game) {
        for (Car car : game.getCars()) {
            System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()) + "\n");
        }
        System.out.println();
    }
}
