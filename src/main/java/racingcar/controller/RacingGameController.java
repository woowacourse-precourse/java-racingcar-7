package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    public void start() {
        String carNamesInput = InputView.getCarNames();
        List<Car> cars = racingGameService.createCars(carNamesInput);

        String moveCountInput = InputView.getMoveCount();
        int moveCount = racingGameService.parseMoveCount(moveCountInput);

        racingGameService.startRace(cars, moveCount);

        List<Car> winners = racingGameService.findWinners(cars);
        racingGameService.printWinners(winners);
    }
}
