package racingcar.Controller;

import racingcar.model.Movement;
import racingcar.model.RaceGame;
import racingcar.model.RoundCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final RaceGame raceGame;
    private final OutputView outputView;
    private final RoundCount roundCount;

    public Controller(InputView inputView, OutputView outputView, Movement movement) {
        this.outputView = outputView;
        GameInitializer gameInitializer = new GameInitializer(inputView);
        this.raceGame = new RaceGame(gameInitializer.createRaceCars(), movement);
        this.roundCount = gameInitializer.getRoundCount();
    }

    public void run() {
        outputView.printResultMessage();
        while (roundCount.hasRemainingRound()) {
            raceGame.moveAllCars();
            outputView.printRoundResult(raceGame.getRoundResult());
            roundCount.decrease();
        }
        outputView.printWinners(raceGame.getWinner());
    }
}
