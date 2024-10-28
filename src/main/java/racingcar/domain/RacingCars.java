package racingcar.domain;

import racingcar.dto.CarStatusDto;

import java.util.List;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars(List<Car> cars) {
        racingCars = cars;
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
}
