package racingcar.view;

import java.util.List;
import racingcar.Racingcar;

public class RoundProcessResultView {

    public static void displayRoundResult(List<Racingcar> cars) {
        for (Racingcar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
