package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputService inputService = new InputService();


    public void racing() {
        List<String> carNames = inputService.getCarNames(inputView.inputCars());
        RacingService racingService = new RacingService(carNames);
        int roundNumber = inputService.getRoundNumber(inputView.inputRoundNumber());
        outputView.printEmptyLine();

        outputView.printRoundResultText();
        for (int round = 0; round < roundNumber; round++) {
            Map<String, Integer> carPositions = racingService.moveCars();
            outputView.printRoundResult(carNames, carPositions);
            outputView.printEmptyLine();
        }
    }
}
