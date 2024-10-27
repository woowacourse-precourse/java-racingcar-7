package racingcar.controller;

import racingcar.dto.RacingInput;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView,RacingService racingService){
        this.inputView =inputView;
        this.racingService =racingService;

    }

    public void run(){
        RacingInput racingInput = inputView.readRacingInput();
        racingService.racing(racingInput);
    }

}
