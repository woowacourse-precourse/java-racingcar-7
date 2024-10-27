package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingGameMaxRound;
import racingcar.model.RacingGameRoundResult;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameProgressService {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final int MINIMUM_MOVE_VALUE = 4;

    public List<RacingGameRoundResult> executeRounds(List<Car> cars, RacingGameMaxRound maxRound) {
        List<RacingGameRoundResult> gameRoundResults = new ArrayList<>();
        for (int round = 0; round < maxRound.getRound(); round++) {
            RacingGameRoundResult gameRoundResult = executeRound(cars, round);
            gameRoundResults.add(gameRoundResult);
        }
        return gameRoundResults;
    }

    private RacingGameRoundResult executeRound(List<Car> cars, int currentRound) {
        List<Car> roundResult = new ArrayList<>();
        for (Car car : cars) {
            if (randomNumberGenerator.generateNumber() >= MINIMUM_MOVE_VALUE) {
                car.move();
            }
            roundResult.add(car.clone());
        }
        return new RacingGameRoundResult(roundResult);
    }
}
