package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.model.moving_strategy.MovingStrategy;
import racingcar.model.validator.RacingCarValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final RacingCarValidator racingCarValidator;
    private final MovingStrategy movingStrategy;

    public RacingService(RacingCarValidator racingCarValidator, MovingStrategy movingStrategy) {
        this.racingCarValidator = racingCarValidator;
        this.movingStrategy = movingStrategy;
    }

    public RacingCars getRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = createRacingCars(carNames);

        return new RacingCars(racingCars);
    }

    public RacingResult play(RacingCars racingCars, int tryCount) {
        List<RacingRoundResult> racingRoundResults = playRounds(racingCars, tryCount);
        RacingCars winners = getWinners(racingCars);

        return new RacingResult(racingRoundResults, winners);
    }

    private List<RacingCar> createRacingCars(List<String> carNameList) {
        return carNameList.stream()
                .map(carName -> new RacingCar(carName, racingCarValidator, movingStrategy))
                .toList();
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
        racingCars.move();
        return new RacingRoundResult(racingCars.getCarNamesAndPositions());
    }
}
