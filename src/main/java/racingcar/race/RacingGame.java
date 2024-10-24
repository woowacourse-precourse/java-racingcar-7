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
        while (goToNextRound()) {
            playRound();
        }
    }

    public List<RacingPlayer<T>> getWinners() {
        return matchResolver.determineWinner(racingPlayers);
    }

    private void playRound() {
        racingPlayers.playEach();
    }

    private boolean goToNextRound() {
        doBetweenRound();
        if (isLastRound()) {
            return false;
        }
        currentRound++;
        return true;
    }

    private boolean isLastRound() {
        return currentRound == matchCount;
    }

    private void doBetweenRound() {
        System.out.println();
    }

}
