package racingcar;

public class RacingGameMachine {

    private RacingGame racingGame;

    public void play() {
        preparation();
        progress();
        complete();
    }

    private void preparation() {
        racingGame = new RacingGame();
        racingGame.preparation();
    }

    private void progress() {
        racingGame.progressAll();
    }

    private void complete() {
        racingGame.printWinner();
    }

}
