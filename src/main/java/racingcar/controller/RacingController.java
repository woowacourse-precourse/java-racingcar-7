package racingcar.controller;


import java.util.List;
import racingcar.domain.Car;
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
        racingService.setUpRacing(userStringInput);
    }

    private void printWinner() {
        outputView.printWinner(racingService.getWinners());
    }

    private void racingStart() {
        int userIntegerInput = racingService.getValidateIntegerInput(
                InputView.getInputRepeatCount());
        outputView.printGameResultMessage();
        List<List<Car>> racingResult = racingService.fullRacing(userIntegerInput);
        for (List<Car> cars : racingResult) {
            outputView.printCarsResult(cars);
        }
    }

}
