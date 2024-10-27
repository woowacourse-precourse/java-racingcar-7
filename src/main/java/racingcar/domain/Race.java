package racingcar.domain;

import static racingcar.constant.ExceptionMessage.RACE_NOT_FINISHED;

import java.util.List;
import racingcar.dto.CarsPositionDto;
import racingcar.dto.WinnerNamesDto;
import racingcar.strategy.MovingStrategy;
import racingcar.vo.CarsPositionSnapshot;

public class Race {
    private final Cars cars;
    private final RoundProgress roundProgress;
    private final RaceHistory raceHistory;

    private Race(Cars cars, RoundProgress roundProgress, RaceHistory raceHistory) {
        this.cars = cars;
        this.roundProgress = roundProgress;
        this.raceHistory = raceHistory;
    }

    public static Race initializeRace(Cars cars, RoundProgress roundProgress) {
        return new Race(cars, roundProgress, RaceHistory.create());
    }

    public void execute(MovingStrategy movingStrategy) {
        while (roundProgress.hasNext()) {
            executeRound(movingStrategy);
        }
    }

    private void executeRound(MovingStrategy movingStrategy) {
        cars.attemptMoveAll(movingStrategy);

        CarsPositionSnapshot snapshot = cars.createSnapshot();
        raceHistory.add(snapshot);

        roundProgress.progress();
    }

    public List<CarsPositionDto> getEntireHistory() {
        return raceHistory.toPositionDtos();
    }

    public WinnerNamesDto getWinners() {
        if (roundProgress.hasNext()) {
            throw new IllegalStateException(RACE_NOT_FINISHED.message());
        }

        List<Car> winningCars = cars.getCarsWithMaxStep();
        return WinnerNamesDto.from(winningCars);
    }
}
