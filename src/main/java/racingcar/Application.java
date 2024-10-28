package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.RacingCarFactory;
import racingcar.service.RacingCarService;
import racingcar.validator.RacingCarNameValidator;
import racingcar.validator.RacingCarRepeatCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = RacingCarFactory.createRacingCarController();
        racingCarController.run();
    }
}