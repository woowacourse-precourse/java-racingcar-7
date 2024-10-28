package racingcar.domain.racing;

import java.util.List;
import java.util.Objects;

import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Racing {

    private final Results results;
    private final Round round;

    private Racing(final int roundTotal) {
        this.results = Results.empty();
        this.round = Round.create(roundTotal);
    }

    public static Racing from(final int roundTotal) {
        return new Racing(roundTotal);
    }

    public void play(final Cars cars, final List<Integer> numbers) {
        cars.moveAll(numbers);
    }

    public void saveRoundResult(final Cars cars) {
        results.saveAll(cars.getCars());
    }

    public List<Name> announceWinners(final Cars cars) {
        Position winnerPosition = results.findWinnerPosition();

        return Objects.requireNonNull(cars.getSamePositionCarNames(winnerPosition));
    }

    public Results results() {
        return results.copy();
    }

    public int roundTotal() {
        return round.total();
    }

}
