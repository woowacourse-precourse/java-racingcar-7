package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    public void start() {
        String carNamesInput = InputView.getCarNames();
        List<Car> cars = racingGameService.createCars(carNamesInput);

        String moveCountInput = InputView.getMoveCount();
        int moveCount = racingGameService.parseMoveCount(moveCountInput);

        for (int i = 0; i < moveCount; i++) {
            racingGameService.raceOneRound(cars);
            OutputView.printRoundResult(cars);
        }

        List<Car> winners = racingGameService.findWinners(cars);
        OutputView.printWinners(winners);
    }
}
