package racingcar.domain.racingcar.service;

import racingcar.domain.racingcar.domain.Race;
import racingcar.domain.racingcar.domain.Car;

import java.util.List;
import racingcar.domain.racingcar.dto.RaceResult;
import racingcar.domain.racingcar.dto.RaceStatus;

public class RaceServiceImpl {

    public Race createRace(List<String> carNames, int totalRounds) {
        validateCarNames(carNames);
        validateTotalRounds(totalRounds);
        return Race.of(carNames, totalRounds);
    }

    public void moveAllCars(Race race) {
        race.moveAllCars();
    }

    public void runFullRace(Race race) {
        while (!race.isRaceFinished()) {
            moveAllCars(race);
        }
    }

    public RaceResult summarizeRace(Race race) {
        List<Car> winners = race.getWinners();
        return new RaceResult(winners, race.getCurrentRound());
    }

    public RaceStatus getCurrentStatus(Race race) {
        return new RaceStatus(race.getCars(), race.getCurrentRound(), race.getTotalRounds());
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1개 이상이어야 합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
    }

    private void validateTotalRounds(int totalRounds) {
        if (totalRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}