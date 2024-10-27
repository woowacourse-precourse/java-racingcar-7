package racingcar.controller;


import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final RacingService racingService;
    private final OutputView outputView;

    public RacingController(RacingService racingService, OutputView outputView) {
        this.racingService = racingService;
        this.outputView = outputView;
    }

    public void start() {
        racingInit();
        racingStart();
        printWinner();
    }

    private void racingInit() {
        String userStringInput = racingService.getValidatedStringInput(
                InputView.getInputCarString());
        racingService.initCars(userStringInput);
    }

    private void printWinner() {
        outputView.printWinner(racingService.getWinners());
    }

    private void racingStart() {
        int userIntegerInput = racingService.getValidateIntegerInput(
                InputView.getInputRepeatCount());
        outputView.printEmptyLine();
        outputView.printGameResultMessage();
        printRacingStatus(userIntegerInput);
    }

    private void printRacingStatus(int userIntegerInput) {
        for (int i=0; i<userIntegerInput; i++){
            outputView.printRacingResult(racingService.onceRacing());
        }
    }

}
