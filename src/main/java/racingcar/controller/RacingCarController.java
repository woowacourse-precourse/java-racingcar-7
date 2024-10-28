package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCarInfo;
import racingcar.model.RacingCarResult;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingCarController {
    private final RacingCarInputView inputView;
    private final RacingCarOutputView outputView;
    private final RacingCarService service;

    public RacingCarController() {
        this.inputView = new RacingCarInputView();
        this.outputView = new RacingCarOutputView();
        this.service = new RacingCarService();
    }

    public void execute() {
        RacingCarInfo input = inputView.readInfo();

        RacingCarResult output = service.runRacingCar(
            List.of(input.carName()),
            input.trialNum()
        );

        outputView.printResult(
            output.racingTrialLogs(),
            output.winners()
        );
    }
}
