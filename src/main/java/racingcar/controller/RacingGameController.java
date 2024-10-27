package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import service.PlayerService;

public class RacingGameController {
    
    private final InputView inputView;
    private final OutputView outputView;
    private final PlayerService playerService;

    public RacingGameController(InputView inputView, OutputView outputView, PlayerService playerService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.playerService = playerService;
    }

    public void run() {
        String carNames = inputView.requestCarNames();
        List<RacingCar> players = playerService.registerPlayers(carNames);
        String numAttempts = inputView.requestNumAttempts();

        RacingGame racingGame = new RacingGame(players, numAttempts);

        while (racingGame.isNotFinished()) {
            racingGame.play();
            outputView.printRoundResults(racingGame);
            racingGame.incrementRound();
        }

        outputView.printFinalWinners(racingGame);
    }
}
