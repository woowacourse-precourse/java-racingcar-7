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
        racingResult();
    }

    private void racingInit() {
        String userStringInput = racingService.getValidatedStringInput(
                InputView.getInputCarString());
        racingService.setUpRacing(userStringInput);
    }

    private void racingResult() {
        int userIntegerInput = racingService.getValidateIntegerInput(
                InputView.getInputRepeatCount());
        outputView.printGameResultMessage();
        printResult(userIntegerInput);
        outputView.printWinner(racingService.getWinners());
    }

    private void printResult(int userInput) {
        List<List<Car>> racingResult = racingService.fullRacing(userInput);
        for (List<Car> cars : racingResult) {
            outputView.printCarsResult(cars);
        }
    }

}
