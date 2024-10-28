package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.RequestView;

import java.util.List;

import static racingcar.message.ErrorMessage.*;
import static racingcar.utils.ExceptionUtils.throwException;

public class NameRequestHandler {

    public List<String> getNames() {
        RequestView.requestNames();
        String rawInput = Console.readLine();
        return validateInput(rawInput);
    }

    private List<String> validateInput(String rawInput) {
        validateBlank(rawInput);
        validateSpace(rawInput);
        List<String> names = List.of(rawInput.split(","));
        validateNames(names);
        return names;
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

    public void validateNames(List<String> names) {
        names.stream()
                .filter(name -> name.isEmpty() || name.length() > 5)
                .findFirst()
                .ifPresent(invalidName -> {
                    throwException(NAME_LENGTH_ERROR);
                });
    }

}
