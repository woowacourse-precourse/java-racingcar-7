package racingcar.controller;

import java.util.List;
import racingcar.car.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<String> carNames = InputView.getCarNames();
        int moveCount = InputView.getMoveCount();

        List<RacingCar> winners = racingCarService.logic(carNames, moveCount);
        OutputView.printWinner(winners);
    }
}
