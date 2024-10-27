package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.dto.CarResultDto;
import racingcar.domain.car.dto.CarsResultDto;
import racingcar.domain.race.Race;

public class Cars {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Car> cars;

    private Cars(final String carNames) {
        this.cars = createCars(carNames);
        validateHasDuplicates();
    }

    public static Cars from(String carNames) {
        return new Cars(carNames);
    }

    private void validateHasDuplicates() {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다");
        }
    }

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(SPLIT_DELIMITER))
                .map(Car::of)
                .toList();
    }

    public CarsResultDto race(Race race) {
        List<CarResultDto> carResultDtos = new ArrayList<>();
        for (Car car : cars) {
            carResultDtos.add(race.move(car));
        }
        return new CarsResultDto(carResultDtos);
    }
}
