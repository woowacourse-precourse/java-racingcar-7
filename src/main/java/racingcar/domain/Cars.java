package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;

public class Cars {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Cars(List<Car> cars, RandomGenerator randomGenerator) {
        validateDuplicatedNames(cars);
        this.cars = new ArrayList<>(cars);
        this.randomGenerator = randomGenerator;
    }

    private void validateDuplicatedNames(List<Car> car) {
        Set<String> uniqueNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
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
