package racingcar.domain.racingcar.dto;

import java.util.List;
import racingcar.domain.racingcar.domain.Car;

public class RaceResult {

    private final List<String> winnerNames;
    private final int totalRounds;

    public RaceResult(List<Car> winners, int totalRounds) {
        this.winnerNames = winners.stream().map(Car::getName).toList();
        this.totalRounds = totalRounds;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

}
