package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.OutputView;

public class CarRacing {
    private final RacingRule racingRule;
    private final int totalRounds;
    private final Racers racers;
    private final OutputView outputView;

    public CarRacing(RacingRule racingRule, int totalRounds, Racers racers, OutputView outputView) {
        this.racingRule = racingRule;
        this.totalRounds = totalRounds;
        this.racers = racers;
        this.outputView = outputView;
    }

    public void start() {
        race();
        announceWinners();
    }

    private void race() {
        outputView.printResultPhrase();
        for (int i = 0; i < totalRounds; i++) {
            racers.tryToMoveWith(racingRule);
            outputView.printProgress(racers.getCurrentResult());
        }
    }

    private void announceWinners() {
        outputView.printWinners(racers.getWinnerNames());
    }

    public void finish() {
        Console.close();
    }
}