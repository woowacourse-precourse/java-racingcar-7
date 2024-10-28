package racingcar.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class RacingService {
    private int roundNumber;
    private Map<String, Integer> carPositions;

    private void setCarsAndRoundNumber(String carsInput, String roundNumberInput) {
        setCars(carsInput);
        setRoundNumber(roundNumberInput);
    }

    private void setCars(String carsInput) {
        if (carsInput == null) {
            throw new IllegalArgumentException();
        }

        List<String> cars = splitCars(carsInput);
        validateCarsInput(cars);
        initializeCarsStatus(cars);
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
        if (cars.stream().anyMatch(car -> car.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarsDuplication(List<String> cars) {
        Set<String> carsSet = new HashSet<>(cars);
        if (carsSet.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void initializeCarsStatus(List<String> cars) {
        cars.forEach(car -> carPositions.put(car, 0));
    }

    private void setRoundNumber(String roundNumberInput) {
        if (roundNumberInput == null) {
            throw new IllegalArgumentException();
        }

        roundNumber = Integer.parseInt(roundNumberInput);
        validateRoundNumberInput();
    }

    private void validateRoundNumberInput() {
        if (roundNumber > 10) {
            throw new IllegalArgumentException();
        }
    }


}
