package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.OutputView;

public class CarRacing {
    private final RacingRule racingRule;
    private final Racers racers;
    private final int totalRounds;
    private final OutputView outputView;

    public CarRacing(RacingRule racingRule, Racers racers, int totalRounds, OutputView outputView) {
        this.racingRule = racingRule;
        this.racers = racers;
        this.totalRounds = totalRounds;
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