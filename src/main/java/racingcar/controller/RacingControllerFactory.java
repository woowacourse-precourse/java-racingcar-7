package racingcar.controller;


import racingcar.domain.Winner;
import racingcar.service.RacingService;
import racingcar.utils.RandomNumber;
import racingcar.validation.Validator;
import racingcar.view.OutputView;

public class RacingControllerFactory {

    public static RacingController create() {
        RandomNumber randomNumber = new RandomNumber();
        Winner winner = new Winner();
        Validator validator = new Validator();
        RacingService racingService = new RacingService(winner, randomNumber, validator);
        OutputView outputView = new OutputView();
        return new RacingController(racingService, outputView);
    }

}
