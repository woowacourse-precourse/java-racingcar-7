package racingcar.model;

import java.util.List;
import racingcar.dto.Result;
import racingcar.util.RandomUtil;

public class RacingGame {
    private List<Car> racer;
    private int round;
    private RandomUtil randomUtil = new RandomUtil();

    public RacingGame(List<Car> racer, int round) {
        validateRound(round);

        this.racer = racer;
        this.round = round;
    }

    private void validateRound(int round) {
        if (round <= 0)
            throw new IllegalArgumentException();
    }

    public List<Result.Round> progress() {
        return racer.stream()
                .map(racer -> racer.go(randomUtil.generateNumber()))
                .toList();
    }
}
