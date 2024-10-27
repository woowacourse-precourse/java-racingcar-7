package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.racer.utils.NumberGenerator;
import racingcar.domain.racer.Racer;
import racingcar.domain.racer.Racers;
import racingcar.domain.racer.utils.impl.RandomNumberGenerator;
import racingcar.domain.round.Round;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void run() {
        RacingGame racingGame = organizeRace();
        playRacingGame(racingGame);
        endRacingGame(racingGame);
    }

    private RacingGame organizeRace() {
        Racers racers = createRacers();
        Round round = prepareRound();

        return new RacingGame(racers, round);
    }
    private Racers createRacers() {
        List<String> carNames = this.inputView.showGetCarNamesInput();

        Racers racers = new Racers();
        carNames.forEach(carName -> racers.add(Racer.of(carName, this.numberGenerator)));

        return racers;
    }

    private Round prepareRound() {
        return new Round(this.inputView.showGetFinalRoundInput());
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
