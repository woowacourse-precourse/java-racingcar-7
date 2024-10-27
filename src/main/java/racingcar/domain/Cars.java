package racingcar.domain;

import static racingcar.constant.ExecptionMessage.CARS_NAME_DUPLICATED_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.exception.CarsNameDuplicatedException;
import racingcar.utils.RandomGenerator;

public class Cars {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Cars(List<Car> cars, RandomGenerator randomGenerator) {
        validateDuplicatedNames(cars);
        this.cars = new ArrayList<>(cars);
        this.randomGenerator = randomGenerator;
    }

    private void validateDuplicatedNames(List<Car> cars) {
        Set<String> uniqueNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != cars.size()) {
            throw new CarsNameDuplicatedException(CARS_NAME_DUPLICATED_MESSAGE.getMessage());
        }
    }

    public void moveAll() {
        cars.forEach(car -> car.move(randomGenerator.generate()));
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public CarsDto toDto() {
        List<CarDto> carDtoList = cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
        return new CarsDto(carDtoList);
    }
}
