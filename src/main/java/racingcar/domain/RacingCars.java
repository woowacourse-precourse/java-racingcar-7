package racingcar.domain;

import racingcar.dto.CarStatusDto;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> racingCars = new ArrayList<>();

    public void registerRacingCars(List<String> carNames) {
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
}
