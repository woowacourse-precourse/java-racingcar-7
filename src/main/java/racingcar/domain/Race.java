package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;
import racingcar.service.Accelerator;

public class Race {
    private final List<Car> cars;

    public Race(String input) {
        validateBlank(input);
        List<Car> cars = convertToCars(input);
        validateDuplicate(cars);
        this.cars = cars;
    }

    public static Race of(String input) {
        return new Race(input);
    }


    public void play(Accelerator accelerator) {
        cars.forEach(accelerator::move);
    }

    public CarDto getCurrentDistances() {
        return CarDto.of(cars);
    }

    public CarDto getWinners() {
        Integer maxDistance = cars.stream()
                .max((o1, o2) -> o1.getCarDistance() - o2.getCarDistance())
                .map(Car::getCarDistance)
                .orElseThrow();
        return CarDto.of(cars.stream()
                .filter(car -> Objects.equals(car.getCarDistance(), maxDistance))
                .toList());
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Car> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> convertToCars(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames.stream()
                .map(Car::createCarAtStartLine)
                .toList();
    }
}
