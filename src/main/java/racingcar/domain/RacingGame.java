package racingcar.domain;

import java.util.List;
import racingcar.domain.racer.Racer;
import racingcar.domain.racer.Racers;
import racingcar.domain.round.Round;
import racingcar.domain.round.RoundHistory;
import racingcar.domain.round.RoundResult;
import racingcar.domain.round.RoundSnapshot;

public class RacingGame {

    private final Racers racers;
    private final Round round;
    private final RoundHistory roundHistory;

    public RacingGame(Racers racers, Round round) {
        this.racers = racers;
        this.round = round;
        this.roundHistory = new RoundHistory();
    }

    public void playNextRound() {
        this.round.nextRound();
        this.racers.moveCars();
        recordCurrentRound();
    }

    private void recordCurrentRound() {
        this.roundHistory.addRoundSnapshot(round.nowRound(), RoundSnapshot.from(getRacers()));
    }

    public List<RoundResult> getRacingResult() {
        return this.roundHistory.getRoundResult(this.round.nowRound());
    }

    public boolean isNotGameOver() {
        return this.round.isNotFinalRound();
    }

    public List<String> getFinalWinners() {
        validateFinalRoundCheck();
        return this.roundHistory.getWinnersByRound(this.round.nowRound());
    }

    private void validateFinalRoundCheck() {
        if (this.isNotGameOver()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Racer> getRacers() {
        return this.racers.racers();
    }

}
