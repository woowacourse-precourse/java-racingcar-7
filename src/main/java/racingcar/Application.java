package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final OutputView outputViewBean = new OutputView();

        final RacingController racingControllerBean = new RacingController(inputViewBean, outputViewBean);

        racingControllerBean.run();
    }
}
