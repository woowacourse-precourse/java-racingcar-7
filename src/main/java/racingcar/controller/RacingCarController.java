package racingcar.controller;

import racingcar.constant.ExceptionMessage;
import racingcar.constant.Message;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        try {
            inputView.printInputCarNameMessage();
            String carNameInput = inputView.getInput();
            racingCarService.settingRacingCars(carNameInput);

            inputView.printInputTryCountMessage();
            String tryCountInput = inputView.getInput();
            String runResult = racingCarService.racingStart(tryCountInput);
            outputView.printRunResult(runResult);

            outputView.printWinnerResult(racingCarService.racingResult());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            throw e;
        } catch (Exception e) {
            outputView.printErrorMessage(e.getClass().toString() + Message.ERROR_SEPARATOR + e.getMessage());
            throw new IllegalArgumentException(ExceptionMessage.UNHANDLED_EXCEPTION_OCCURRED);
        }
    }
}
