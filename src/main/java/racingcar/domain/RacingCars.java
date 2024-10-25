package racingcar.domain;

import racingcar.dto.CarStatusDto;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> racingCars = new ArrayList<>();

    public void registerCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(racingCars::add);
    }

    public void updatePositionsWithRandomNumbers(List<Integer> randomNumbers) {
        for (int i = 0; i < racingCars.size(); i++) {
            int moveCondition = randomNumbers.get(i);
            racingCars.get(i).move(moveCondition);
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
                .filter(raceResult -> raceResult.getPosition() == maxPosition)
                .map(CarStatusDto::getName)
                .toList();
    }

    private int getMaxPosition(List<CarStatusDto> raceResults) {
        return raceResults.stream()
                .mapToInt(CarStatusDto::getPosition)
                .max()
                .orElse(0);
    }
}
