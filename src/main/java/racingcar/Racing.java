package racingcar;

public class Racing {
    private final Racers racers;
    private final RacingRule racingRule;
    private final OutputView outputView;
    private final int totalRounds;

    public Racing(Racers racers, RacingRule racingRule, OutputView outputView, int totalRounds) {
        this.racers = racers;
        this.racingRule = racingRule;
        this.outputView = outputView;
        this.totalRounds = totalRounds;
    }

    public void race() {
        outputView.printResultPhrase();
        for (int i = 0; i < totalRounds; i++) {
            racers.tryToMoveWith(racingRule);
            outputView.printProgress(racers.getCurrentResult());
        }
    }

    public void announceWinners() {
        outputView.printWinners(racers.getWinnerNames());
    }
}