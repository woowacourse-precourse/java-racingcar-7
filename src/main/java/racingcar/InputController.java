package racingcar;

import static racingcar.ViewConstants.NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;

public class InputController {
    private final InputValidator inputValidator;

    public InputController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> extractCarNames(String input) {
        List<String> carNames = splitByDelimiter(input);
        inputValidator.validateCountOf(carNames);
        inputValidator.validateNonDuplicate(carNames);
        return carNames;
    }

    private List<String> splitByDelimiter(String input) {
        return Arrays.stream(input.split(NAME_DELIMITER)).toList();
    }

    public int convertToNumber(String input) {
        inputValidator.validateThatContainsOnlyDigits(input);
        int number = Integer.parseInt(input);
        inputValidator.validateMinRoundsOrOver(number);
        return number;
    }
}
