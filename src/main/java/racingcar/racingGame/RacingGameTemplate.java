package racingcar.racingGame;

public abstract class RacingGameTemplate {

    public final void play() {
        initializeGame();
        race();
        announceWinners();
    }

    protected abstract void initializeGame();

    protected abstract void race();

    protected abstract void announceWinners();
}
