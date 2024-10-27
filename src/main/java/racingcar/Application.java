package racingcar;

import racingcar.controller.RacingController;
import racingcar.exception.RacingCarException;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final OutputView outputViewBean = new OutputView();
        final ErrorView errorViewBean = new ErrorView();

        final RacingController racingControllerBean = new RacingController(inputViewBean, outputViewBean);

        try {
            racingControllerBean.run();
        } catch (RacingCarException e) {
            errorViewBean.errorPage(e.getMessage());
        }
    }
}
