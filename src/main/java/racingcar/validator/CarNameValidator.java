package racingcar.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.message.ErrorMessage;

public class CarNameValidator {
    private final static int MAX_LENGTH = 5;
    private final static String DELIM = ",";
    public List<String> validCarNames = new ArrayList<>();

    public List<String> validate(String carNames) {
        validateUserInput(carNames);
        List<String> names = tokenizerNames(carNames);
        for (String name : names) {
            validateEachName(name);
            validCarNames.add(name);
        }
        return validCarNames;
    }

    private void validateUserInput(String carNames) {
        validateBlank(carNames);
        validateContainComma(carNames);
    }

    private List<String> tokenizerNames(String carNames) {
        List<String> names = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames, DELIM);
        while (stringTokenizer.hasMoreTokens()) {
            names.add(stringTokenizer.nextToken());
        }
        return names;
    }

    private void validateEachName(String carNames) {
        validateMoreThanFive(carNames);
        validateDuplicate(carNames);
    }

    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.COMMON_INPUT_BLANK_ERROR.getMessage());
        }
    }

    public void validateContainComma(String input) {
        if (!input.contains(DELIM)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_SEPARATOR_ERROR.getMessage());
        }
    }

    public void validateDuplicate(String carName) {
        if (validCarNames.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NOT_DUPLICATE_ERROR.getMessage());
        }
    }

    public void validateMoreThanFive(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEEDED_ERROR.getMessage());
        }
    }

}
