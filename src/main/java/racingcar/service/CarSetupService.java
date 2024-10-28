package racingcar.service;

import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;
import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarSetupService implements CarSetup {
    private final InputValidator inputValidator;

    public CarSetupService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public List<Car> parseCarNames(String input) {
        inputValidator.validateIsEmpty(input);
        HashSet<String> carNamesSet = new HashSet<>();
        List<Car> cars = new ArrayList<>();
        cars =  Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(this::validateCarName)
                .peek(name -> validateDuplicateName(name, carNamesSet))
                .map(this::createCar)
                .collect(Collectors.toCollection(ArrayList::new));
        return  cars;
    }

    @Override
    public int parseAttemptCount(String input) {
        inputValidator.validateAttemptCount(input);
        int count = Integer.parseInt(input);
        return count;
    }


    private void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
        }
        inputValidator.validateCarNameLength(name);
    }

    private void validateDuplicateName(String name, HashSet<String> carNamesSet) {
        if (!carNamesSet.add(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }
}
