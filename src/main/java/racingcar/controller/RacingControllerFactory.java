package racingcar.controller;


import racingcar.domain.Racing;
import racingcar.service.RacingService;
import racingcar.utils.RandomNumber;
import racingcar.view.OutputView;

public class RacingControllerFactory {

    public static RacingController create() {
        RandomNumber randomNumber = new RandomNumber();
        Racing racing = new Racing();
        RacingService racingService = new RacingService(racing, randomNumber);
        OutputView outputView = new OutputView();
        return new RacingController(racingService, outputView);
    }

}
