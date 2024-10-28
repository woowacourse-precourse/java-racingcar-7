package racingcar.racing;

public abstract class RacingGameTemplate {

    public final void play() {
        race();
        announceWinners();
    }

    protected abstract void race();

    protected abstract void announceWinners();
}
