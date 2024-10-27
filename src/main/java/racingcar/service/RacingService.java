package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RoundProgress;
import racingcar.dto.RaceResultDto;
import racingcar.strategy.MovingStrategy;
import racingcar.vo.Name;
import racingcar.vo.Round;

public class RacingService {
    public RaceResultDto createAndExecute(List<String> carNames, int roundCount, MovingStrategy strategy) {
        Race race = createRace(carNames, roundCount);
        race.execute(strategy);

        return RaceResultDto.of(
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
