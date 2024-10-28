package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class InputService {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_ROUND_NUMBER = 10;


    public List<String> getCarNames(String carsInput) {
        if (carsInput == null) {
            throw new IllegalArgumentException();
        }

        List<String> cars = splitCars(carsInput);
        validateCarsInput(cars);
        return cars;
    }

    private List<String> splitCars(String carsInput) {
        return Stream.of(carsInput.split(","))
                .map(String::trim)
                .toList();
    }

    private void validateCarsInput(List<String> cars) {
        checkCarsLength(cars);
        checkCarsDuplication(cars);
    }

    private void checkCarsLength(List<String> cars) {
        if (cars.stream().anyMatch(car -> car.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarsDuplication(List<String> cars) {
        Set<String> carsSet = new HashSet<>(cars);
        if (carsSet.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int getRoundNumber(String roundNumberInput) {
        if (roundNumberInput == null) {
            throw new IllegalArgumentException();
        }

        int roundNumber = Integer.parseInt(roundNumberInput);
        validateRoundNumberInput(roundNumber);
        return roundNumber;
    }

    private void validateRoundNumberInput(int roundNumber) {
        if (roundNumber > MAX_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
