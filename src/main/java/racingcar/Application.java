package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final RacingController racingControllerBean = new RacingController(inputViewBean);

        racingControllerBean.run();
    }
}
