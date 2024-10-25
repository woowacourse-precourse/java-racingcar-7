package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.round.Round;
import racingcar.domain.round.RoundHistory;
import racingcar.domain.round.RoundResult;
import racingcar.domain.round.RoundSnapshot;

public class RacingGame {

    private final List<Car> cars;
    private final Round round;
    private final RoundHistory roundHistory;

    public RacingGame(List<Car> cars, int finalRound) {
        this.cars = cars;
        this.round = new Round(finalRound);
        this.roundHistory = new RoundHistory();
    }

    public void playNextRound() {
       this.round.nextRound();
        moveCars();
        recordCurrentRound();
    }

    private void moveCars() {
        this.cars.forEach(Car::forward);
    }

    private void recordCurrentRound() {
        this.roundHistory.addRoundSnapshot(round.nowRound(), RoundSnapshot.from(this.cars));
    }

    public List<RoundResult> getRacingResult() {
        return this.roundHistory.getRoundResult(this.round.nowRound());
    }

    public boolean isNotGameOver() {
        return this.round.isNotFinalRound();
    }

    public List<String> getFinalWinners() {
        if (this.isNotGameOver()) {
            throw new IllegalArgumentException();
        }

        return this.roundHistory.getWinnersByRound(this.round.nowRound());
    }

}
