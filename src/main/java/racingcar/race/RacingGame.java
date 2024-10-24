package racingcar.race;

import java.util.List;

public class RacingGame<T extends RacingPlayer<T>> {

    private final Players<RacingPlayer<T>> racingPlayers;
    private final MatchResolver matchResolver;
    private final int matchCount;
    private int currentRound;

    public RacingGame(List<RacingPlayer<T>> racingPlayers, int matchCount) {
        this.racingPlayers = new Players<>(racingPlayers);
        this.matchResolver = new MatchResolver();
        this.matchCount = matchCount;
        this.currentRound = 1;
    }

    public void play() {
        doBeforePlay();
        while (goToNextRound()) {
            playRound();
            doAfterRound();
        }
    }

    public List<RacingPlayer<T>> getWinners() {
        return matchResolver.determineWinner(racingPlayers);
    }

    private void playRound() {
        racingPlayers.playEach();
    }

    private boolean goToNextRound() {
        if (isLastRound()) {
            return false;
        }
        currentRound++;
        return true;
    }

    private boolean isLastRound() {
        return currentRound == matchCount;
    }

    private void doBeforePlay() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void doAfterRound() {
        System.out.println();
    }

}
