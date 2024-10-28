package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.Round;
import racingcar.service.Accelerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Accelerator accelerator;

    public RacingCarController(InputView inputView, OutputView outputView, Accelerator accelerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.accelerator = accelerator;
    }

    public void run() {
        Race race = Race.of(inputView.readCars());
        Round round = Round.of(inputView.readRound());
        outputView.printResult();
        while (round.hasRound()) {
            playOnce(race, round);
            outputView.printCurrentResult(race.getCurrentDistances());
        }
        outputView.printWinners(race.getWinners());
    }

    private void playOnce(Race race, Round round) {
        race.play(accelerator);
        round.reduceRound();
    }
}
