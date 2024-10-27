package racingcar.domain;

import racingcar.dto.CarStatusDto;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.MaxRacingCarCountException;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final int CAR_COUNT_THRESHOLD = 10;

    private final List<Car> racingCars = new ArrayList<>();

    public void registerCars(List<String> carNames) {
        validateUniqueName(carNames);
        validateRacingCarCount(carNames);
        carNames.stream()
                .map(Car::new)
                .forEach(racingCars::add);
    }

    public void updatePositionsWithRandomNumbers(List<Integer> randomNumbers) {
        for (int i = 0; i < racingCars.size(); i++) {
            int randomNumber = randomNumbers.get(i);
            racingCars.get(i).move(randomNumber);
        }
    }

    public List<CarStatusDto> getStatus() {
        return racingCars.stream()
                .map(Car::toCarStatusDto)
                .toList();
    }

    public List<String> selectWinners() {
        List<CarStatusDto> raceResults = getStatus();
        int maxPosition = getMaxPosition(raceResults);

        return raceResults.stream()
                .filter(raceResult -> raceResult.position() == maxPosition)
                .map(CarStatusDto::name)
                .toList();
    }

    private int getMaxPosition(List<CarStatusDto> raceResults) {
        return raceResults.stream()
                .mapToInt(CarStatusDto::position)
                .max()
                .orElse(0);
    }

    private void validateUniqueName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new DuplicateNameException();
        }
    }

    private void validateRacingCarCount(List<String> carNames) {
        if (carNames.size() > CAR_COUNT_THRESHOLD) {
            throw new MaxRacingCarCountException();
        }
    }
}
