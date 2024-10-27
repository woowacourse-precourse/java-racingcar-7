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

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> {
                    if (name.isEmpty()) {
                        throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
                    }
                    return true;
                })
                .peek(inputValidator::validateCarNameLength)
                .filter(name -> {
                    if (!carNamesSet.add(name)) {
                        throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
                    }
                    return true;
                })
                .map(name -> new Car(name, 0))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public int parseAttemptCount(String input) {
        inputValidator.validateAttemptCount(input);

        return Integer.parseInt(input);
    }
}
