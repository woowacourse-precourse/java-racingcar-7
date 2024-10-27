package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

import static racingcar.message.ErrorMessage.*;
import static racingcar.message.InfoMessage.REQUEST_NAMES_MESSAGE;
import static racingcar.utils.ExceptionUtils.throwException;

public class NameRequestHandler {

    public String[] getNames() {
        System.out.println(REQUEST_NAMES_MESSAGE.getMessage());
        String rawInput = Console.readLine();
        return validateInput(rawInput);
    }

    private String[] validateInput(String rawInput) {
        validateBlank(rawInput);
        validateSpace(rawInput);
        String[] rawNames = rawInput.split(",");
        validateNames(rawNames);
        return rawNames;
    }


    public void validateBlank(String rawInput) {
        if (rawInput == null || rawInput.isBlank()) {
            throwException(BLANK_INPUT_ERROR);
        }
    }

    public void validateSpace(String rawInput) {
        if (rawInput.matches(".*\\s.*")) {
            throwException(CONTAINS_SPACE_ERROR);
        }
    }

    public void validateNames(String[] rawNames) {
        Arrays.stream(rawNames)
                .filter(rawName -> rawName.isEmpty() || rawName.length() > 5)
                .findFirst()
                .ifPresent(invalidName -> {
                    throwException(NAME_LENGTH_ERROR);
                });
    }

}
