package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.ErrorMessage;

public class Race {
    List<Car> cars;
    int trial;

    public Race(List<Car> cars, int trial) {
        validateCars(cars);
        validateTrial(trial);
        this.cars = cars;
        this.trial = trial;
    }

    private void validateTrial(int trial) {
        if (trial <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_UNDER_ZERO.getMessage());
        }
    }

    private void validateCars(List<Car> cars) {
        int carCount = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet()).size();
                
        if (carCount != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.getMessage());
        }
    }

    public List<Car> getWinner() {
        int maximumDistance = cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo).orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maximumDistance)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getTrial() {
        return this.trial;
    }
}
