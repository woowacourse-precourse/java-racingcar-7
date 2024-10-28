package racingcar.service;

import static racingcar.View.ViewConstants.LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE;
import static racingcar.config.RacingConstants.INITIAL_MOVE_COUNT;
import static racingcar.config.RacingConstants.MAX_NUMBER_IN_RANGE;
import static racingcar.config.RacingConstants.MIN_NUMBER_IN_RANGE;
import static racingcar.config.RacingConstants.MIN_NUMBER_TO_MOVE;
import static racingcar.config.RacingConstants.MIN_ROUNDS;

import java.util.List;

public class CarRacingService {
    public RacingRule setRacingRule() {
        return new RacingRule(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE, MIN_NUMBER_TO_MOVE);
    }

    public Racers registerRacers(List<String> carNames) {
        return new Racers(carNames.stream()
                .map(name -> new Car(name, INITIAL_MOVE_COUNT))
                .toList());
    }

    public int registerTotalRounds(int number) {
        validateMinRoundsOrOver(number);
        return number;
    }

    private void validateMinRoundsOrOver(int number) {
        if (number < MIN_ROUNDS) {
            throw new IllegalArgumentException(LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE);
        }
    }
}