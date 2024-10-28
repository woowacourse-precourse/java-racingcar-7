package racingcar;

public class Racing {
    private final Racers racers;
    private final Move move;
    private final OutputView outputView;
    private final int totalRounds;

    public Racing(Racers racers, Move move, OutputView outputView, int totalRounds) {
        this.racers = racers;
        this.move = move;
        this.outputView = outputView;
        this.totalRounds = totalRounds;
    }

    public void race() {
        outputView.printResultPhrase();
        for (int i = 0; i < totalRounds; i++) {
            racers.moveForward(move);
            outputView.printProgress(racers.getCurrentResult());
        }
    }

    public void announceWinners() {
        outputView.printWinners(racers.getWinnerNames());
    }
}