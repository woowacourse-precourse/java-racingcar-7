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
        inputValidator.validateCompetitor(input);
        List<String> carNames = splitByDelimiter(input);
        inputValidator.validateDuplicateName(carNames);
        return carNames;
    }

    private List<String> splitByDelimiter(String input) {
        return Arrays.stream(input.split(NAME_DELIMITER)).toList();
    }

    public int convertToNumber(String input) {
        inputValidator.checkHasNumberOnly(input);
        int number = Integer.parseInt(input);
        inputValidator.checkIsGreaterThanZero(number);
        return number;
    }
}
