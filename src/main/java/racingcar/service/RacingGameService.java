package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameService {

    private RacingGame game;

    public void initGame(List<RacingCar> carList, int loopCount) {
        this.game = new RacingGame(carList, loopCount);
    }

    public void playRounds() {
        for (int currentRound = 0; currentRound < game.getLoopCount(); currentRound++) {
            game.playRound();
            printRoundResult();
        }
    }

    private void printRoundResult() {
        OutputView.printCarsStatus(game.getCars());
        OutputView.printLineBreaking();
    }

    public List<RacingCar> findWinners() {
        return game.findWinners();
    }
}
