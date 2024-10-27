package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.List;

public class OutputView {
    public static void printRoundResult(RacingGame game) {
        for (Car car : game.getCars()) {
            System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()) + "\n");
        }
        System.out.println();
    }

    public static void printFinalWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
