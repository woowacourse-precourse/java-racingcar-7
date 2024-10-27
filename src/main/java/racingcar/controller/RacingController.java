package racingcar.controller;

import racingcar.dto.RacingInput;
import racingcar.dto.RacingResult;
import racingcar.service.RacingService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView,OutputView outputView,RacingService racingService){
        this.inputView =inputView;
        this.racingService =racingService;
        this.outputView =outputView;

    }

    public void run(){

        RacingInput racingInput = inputView.readRacingInput();

        InputValidator.validateCarNames(racingInput.getCarNames());
        InputValidator.validateTryCounts(racingInput.getTryCount());
        InputValidator.checkDuplicateNames(racingInput.getCarNames());

        RacingResult racingResult = racingService.racing(racingInput);

        printRacingResult(racingResult);
    }

    private void printRacingResult(RacingResult racingResult) {
        outputView.printRacingResult(racingResult);
    }

}
