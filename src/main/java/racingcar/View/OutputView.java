package racingcar.View;

import racingcar.Controller.ForwardController;

import java.util.List;

public class OutputView {
    public static void showRoundResult(List<ForwardController> cars) {
        for (ForwardController car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
