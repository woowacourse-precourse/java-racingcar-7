package racingcar.controller;

import java.util.Map;
import racingcar.model.Racing;
import racingcar.service.InputService;
import racingcar.view.InputView;

public class RacingController {

    public RacingController() {
    }

    public void run() {
        InputView inputView = new InputView();
        inputView.printInputView();

        InputService inputService = new InputService();
        Map<String, Integer> racingCars = inputService.splitAndSaveCarName(inputView.getCarNames());
        Integer racingTotalRound = inputView.getTotalRacingRound();
        Racing racing = new Racing(racingCars, racingTotalRound);
        racing.race();
    }
}
