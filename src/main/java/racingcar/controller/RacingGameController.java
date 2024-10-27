package racingcar.controller;

import racingcar.domain.car.CarGroup;
import racingcar.domain.game.GameInitializer;
import racingcar.domain.game.GameRound;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingGameController(RacingGameService racingGameService, InputView inputView, OutputView outputView) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        CarGroup carGroup = initializeCars();
        GameRound gameRound = initializeGameRound();
        runGame(carGroup, gameRound);
        printWinners(carGroup);
    }

    private CarGroup initializeCars() {
        return GameInitializer.createCars(inputView.requestCarNames());
    }

    private GameRound initializeGameRound() {
        return GameInitializer.setRound(inputView.requestNumberOfGames());
    }

    private void runGame(CarGroup carGroup, GameRound gameRound) {
        outputView.printRoundResult(racingGameService.runGameRounds(gameRound, carGroup));
    }

    private void printWinners(CarGroup carGroup) {
        outputView.printWinnerList(racingGameService.getWinners(carGroup));
    }
}
