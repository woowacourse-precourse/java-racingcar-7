package racingcar.controller;

import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputService inputService = new InputService();


    public void racing() {
        String carsInput = inputView.inputCars();
        RacingService racingService = new RacingService(carsInput, inputService);
        int roundNumber = inputService.getRoundNumber(inputView.inputRoundNumber());

        for (int round = 0; round < roundNumber; round++) {
            racingService.moveCars();
        }
    }
}
