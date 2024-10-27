package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarType;

public class RacingConfig {
    private static final long MAX_CAR_NAME_LENGTH = 5L;
    private static final String carsDelimiter = ",";

    private final List<Car> cars;
    private final long rounds;

    public RacingConfig(String cars, String rounds, CarType cartype) {
        validateCarsFormat(cars);
        validateRoundsFormat(rounds);

        this.cars = registerCar(cars, cartype);
        this.rounds = Long.parseLong(rounds);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public long getRounds() {
        return rounds;
    }

    private List<Car> registerCar(String cars, CarType cartype) {
        return splitCarNames(cars).stream()
                .map(name -> CarFactory.create(name, cartype))
                .toList();
    }

    private List<String> splitCarNames(String cars) {
        return Arrays.stream(cars.split(carsDelimiter))
                .toList();
    }

    private void validateCarsFormat(String cars) {
        List<String> carNames = splitCarNames(cars);

        carNames.forEach(this::validateCarNameFormat);
        validateDuplicatedCarNames(carNames);
    }

    private void validateCarNameFormat(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름이 비어있습니다.");
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다");
        }
    }

    private void validateDuplicatedCarNames(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateRoundsFormat(String rounds) {
        try {
            long result = Long.parseLong(rounds);
            validatePositiveNumber(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }
    }

    private void validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닙니다.");
        }
    }
}
