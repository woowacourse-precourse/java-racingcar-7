package racingcar.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import racingcar.api.RandomsApiClient;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.racing.NumberRange;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.Results;
import racingcar.dto.RacingCarResponse;

public class RacingCarService {

    public RacingCarResponse startRacing(final List<String> nameValues, final int roundTotal) {
        Cars cars = Cars.from(nameValues);
        Racing racing = Racing.from(roundTotal);

        playRacingCar(racing, cars);

        return Objects.requireNonNull(getRacingCarResponse(racing, cars));
    }

    private void playRacingCar(final Racing racing, final Cars cars) {
        for (int currentRound = 0; currentRound < racing.roundTotal(); currentRound++) {
            List<Integer> randomNumbers = Objects.requireNonNull(getRandomNumbers(cars.size()));

            racing.play(cars, randomNumbers);
            racing.saveRoundResult(cars);
        }
    }

    private List<Integer> getRandomNumbers(final int carTotalCount) {
        return IntStream.range(0, carTotalCount)
                .mapToObj(randomNumber -> createRandomNumber())
                .toList();
    }

    private RacingCarResponse getRacingCarResponse(final Racing racing, final Cars cars) {
        Results results = racing.results();
        List<Name> winners = racing.announceWinners(cars);

        return RacingCarMessageMapper.toResponse(results, winners);
    }

    private int createRandomNumber() {
        NumberRange movementRange = NumberRange.RANDOM_NUMBER_RANGE;
        return RandomsApiClient.getRandomNumber(movementRange.start(), movementRange.end());
    }

}
