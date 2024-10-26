package racingcar.parser;

import racingcar.domain.car.Car;
import racingcar.exception.ErrorMessage;
import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final InputValidator inputValidator;

    public InputParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

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
}