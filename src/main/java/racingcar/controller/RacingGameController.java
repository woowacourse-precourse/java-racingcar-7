package racingcar.controller;

import racingcar.domain.car.CarGroup;
import racingcar.domain.game.GameRound;
import racingcar.factory.GameInitializer;
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
        CarGroup carGroup = GameInitializer.createCars((inputView.requestCarNames()));
        GameRound gameRound = GameInitializer.setRound(inputView.requestNumberOfGames());
        outputView.printRoundResult(racingGameService.runGameRounds(gameRound, carGroup));
        outputView.printWinnerList(racingGameService.getWinners(carGroup));
    }
}
