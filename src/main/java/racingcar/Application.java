package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingController = new RacingCarController();

        try {
            racingController.run();
        } catch (IllegalArgumentException e) {
            OutputView.printExcetionMessage(e);
        }
    }
}
