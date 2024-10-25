package racingcar.service;

import racingcar.dto.RacingResult;
import racingcar.dto.RacingRoundResult;
import racingcar.exception.ExceptionFactory;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.model.dependency.validator.RacingCarValidator;
import racingcar.service.dependency.random_maker.RandomNumberMaker;

import java.util.ArrayList;
import java.util.List;

import static racingcar.exception.ExceptionType.TRY_COUNT_TOO_SMALL;

public class RacingService {

    private final int MIN_TRY_COUNT = 1;

    private final RandomNumberMaker randomNumberMaker;
    private final RacingCarValidator racingCarValidator;

    public RacingService(RandomNumberMaker randomNumberMaker, RacingCarValidator racingCarValidator) {
        this.randomNumberMaker = randomNumberMaker;
        this.racingCarValidator = racingCarValidator;
    }

    public RacingCars getRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = createRacingCars(carNames);

        return new RacingCars(racingCars);
    }

    public RacingResult play(RacingCars racingCars, int tryCount) {
        validateTryCount(tryCount);
        List<RacingRoundResult> racingRoundResults = playRounds(racingCars, tryCount);
        RacingCars winners = getWinners(racingCars);

        return new RacingResult(racingRoundResults, winners);
    }

    private List<RacingCar> createRacingCars(List<String> carNameList) {
        return carNameList.stream()
                .map(carName -> new RacingCar(carName, racingCarValidator))
                .toList();
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw ExceptionFactory.createException(TRY_COUNT_TOO_SMALL,
                    MIN_TRY_COUNT + " " + "이상이어야 합니다.");
        }
    }

    private RacingCars getWinners(RacingCars racingCars) {
        return racingCars.getMaxPositionCars();
    }

    private List<RacingRoundResult> playRounds(RacingCars racingCars, int tryCount) {
        List<RacingRoundResult> racingRoundResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingRoundResults.add(playRound(racingCars));
        }

        return racingRoundResults;
    }

    private RacingRoundResult playRound(RacingCars racingCars) {
        racingCars.move(randomNumberMaker);
        return new RacingRoundResult(racingCars.getCarNamesAndPositions());
    }
}
