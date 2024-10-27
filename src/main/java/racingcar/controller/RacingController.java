package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.racer.Racers;
import racingcar.domain.racer.movecondition.impl.RandomNumberGenerator;
import racingcar.domain.round.Round;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        RacingGame racingGame = organizeRace();
        playRacingGame(racingGame);
        endRacingGame(racingGame);
    }

    private RacingGame organizeRace() {
        Racers racers = Racers.of(this.inputView.showGetCarNamesInput(), new RandomNumberGenerator());
        Round round = Round.from(this.inputView.showGetFinalRoundInput());

        return new RacingGame(racers, round);
    }

    private void endRacingGame(RacingGame racingGame) {
        this.outputView.showFinalWinners(racingGame.getFinalWinners());
    }

    private void playRacingGame(RacingGame racingGame) {
        this.outputView.showPlayGame();

        while (racingGame.isNotGameOver()) {
            playNextRound(racingGame);
        }
    }

    private void playNextRound(RacingGame racingGame) {
        racingGame.playNextRound();
        this.outputView.showRacingResult(racingGame.getRacingResult());
    }

}
