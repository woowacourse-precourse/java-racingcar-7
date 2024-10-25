package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.validation.CarNameValidator;
import racingcar.validation.NameValidator;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutPutView;
import racingcar.view.OutPutViewImpl;

public class AppConfig {

    public RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(), inputView(), outPutView());
    }

    public RacingCarService racingCarService() {
        return new RacingCarServiceImpl(nameValidator());
    }

    public NameValidator nameValidator() {
        return new CarNameValidator();
    }

    public InputView inputView() {
        return new InputViewImpl();
    }

    public OutPutView outPutView() {
        return new OutPutViewImpl();
    }
}
