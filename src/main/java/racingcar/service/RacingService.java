package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RoundProgress;
import racingcar.dto.RaceResult;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.vo.Name;
import racingcar.vo.Round;

public class RacingService {
    public RaceResult createAndExecute(List<String> carNames, int roundCount) {
        Race race = createRace(carNames, roundCount);
        executeRace(race);

        return RaceResult.of(
                race.getEntireHistory(),
                race.getWinners()
        );
    }

    private Race createRace(List<String> carNames, int roundCount) {
        Cars cars = createCars(carNames);
        Round round = Round.from(roundCount);
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(round);

        return Race.initializeRace(cars, roundProgress);
    }

    private void executeRace(Race race) {
        race.execute(RandomMovingStrategy.getInstance());
    }

    private Cars createCars(List<String> carNames) {
        List<Name> names = carNames.stream()
                .map(Name::from)
                .toList();
        List<Car> cars = names.stream()
                .map(Car::withName)
                .toList();

        return Cars.from(cars);
    }
}