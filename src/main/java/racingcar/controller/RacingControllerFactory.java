package racingcar.controller;


import racingcar.domain.Racing;
import racingcar.service.RacingService;
import racingcar.utils.RandomNumber;
import racingcar.validation.Validator;
import racingcar.view.OutputView;

public class RacingControllerFactory {

    public static RacingController create() {
        RandomNumber randomNumber = new RandomNumber();
        Racing racing = new Racing();
        Validator validator = new Validator();
        RacingService racingService = new RacingService(racing, randomNumber, validator);
        OutputView outputView = new OutputView();
        return new RacingController(racingService, outputView);
    }

}
