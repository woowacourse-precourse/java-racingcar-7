package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final RandomNumber randomNumber;

    public RacingCarController(
            InputView inputView,
            OutputView outputView,
            RacingCarService racingCarService,
            RandomNumber randomNumber
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.randomNumber = randomNumber;
    }

    public void startGame() {
        List<String> carNames = inputView.inputCarNames();
        int numberOfMoves = inputView.inputNumberOfMoves();

        racingCarService.prepare(carNames, randomNumber);
        racingCarService.race();

        outputView.outputMoveResult(racingCarService.getMoveResult());
        outputView.outputWinnerCars(racingCarService.findWinnerCars());
    }
}
