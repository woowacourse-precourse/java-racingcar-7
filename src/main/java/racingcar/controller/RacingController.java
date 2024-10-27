package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.InputDecodeService;
import racingcar.service.InputValidationService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private InputView inputView;
    private OutputView outputView;
    private InputValidationService inputValidationService;
    private InputDecodeService inputDecodeService;
    private RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidationService = new InputValidationService();
        this.inputDecodeService = new InputDecodeService();
        this.racingService = new RacingService();
    }

    public void startRacing() {
        List<Car> cars = prepareCar();
        int roundCount = prepareRoundCount();
        processRacing(cars, roundCount);
        printWinners(cars);
    }

    private List<Car> prepareCar() {
        String rawCarNames = inputView.inputCarNames();
        inputValidationService.validateRawCarNames(rawCarNames);
        return inputDecodeService.decodeRawCarNames(rawCarNames);
    }

    private int prepareRoundCount() {
        String rawRoundCount = inputView.inputRoundCount();
        inputValidationService.validateRawRoundCount(rawRoundCount);
        return inputDecodeService.decodeRawRoundCount(rawRoundCount);
    }

    private void processRacing(List<Car> cars, int roundCount) {
        outputView.outputRacingProcessingStart();
        for (int i = 0; i < roundCount; i++) {
            racingService.processRound(cars);
            outputView.outputCarDetails(cars);
        }
    }

    private void printWinners(List<Car> cars) {
        List<Car> winners = racingService.findWinners(cars);
        outputView.outputWinners(winners);
    }
}
