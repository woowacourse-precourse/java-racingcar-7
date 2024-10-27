package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.InputDecodeService;
import racingcar.service.InputValidationService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationService inputValidationService;
    private final InputDecodeService inputDecodeService;
    private final RacingService racingService;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        inputValidationService = new InputValidationService();
        inputDecodeService = new InputDecodeService();
        racingService = new RacingService();
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
        outputView.outputCustomContent("실행 결과");
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
