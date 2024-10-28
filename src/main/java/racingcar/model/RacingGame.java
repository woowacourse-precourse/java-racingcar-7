package racingcar.model;

import java.util.Comparator;
import java.util.List;
import racingcar.dto.Result;
import racingcar.dto.Result.Round;
import racingcar.util.RandomUtil;

public class RacingGame {
    private List<Car> racer;
    private int round;
    private RandomUtil randomUtil = new RandomUtil();
    private List<Result.Round> resultOfRound;

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
        List<Result.Round> resultOfRound = racer.stream()
                .map(racer -> racer.go(randomUtil.generateNumber()))
                .toList();

        this.resultOfRound = resultOfRound;

        return resultOfRound;
    }

    public List<String> selectWinner() {
        Result.Round maxStep = resultOfRound.stream()
                .max(Comparator.comparingInt(Result.Round::getStep))
                .orElseThrow();

        return resultOfRound.stream()
                        .filter(result -> Comparator
                                .comparing(Result.Round::getStep)
                                .compare(result, maxStep) == 0 )
                        .map(Round::getName)
                        .toList();
    }
}
