package racingcar.domain.racingcar.service;

import racingcar.domain.racingcar.domain.Race;
import racingcar.domain.racingcar.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class RaceServiceImpl implements RaceService {
    private static RaceServiceImpl instance;

    private RaceServiceImpl() {}

    public static RaceServiceImpl getInstance() {
        if (instance == null) {
            instance = new RaceServiceImpl();
        }
        return instance;
    }

    @Override
    public Race createRace(List<String> carNames, int rounds) {
        validateCarNames(carNames);
        validateRounds(rounds);
        return Race.of(carNames, rounds);
    }

    @Override
    public void moveAllCars(Race race) {
        race.moveAllCars();
    }

    @Override
    public List<String> getWinnerNames(Race race) {
        return race.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getRaceStatus(Race race) {
        return race.getCars().stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1개 이상이어야 합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}