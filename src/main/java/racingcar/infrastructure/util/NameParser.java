package racingcar.infrastructure.util;

import racingcar.presentation.enums.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    public List<String> parsingName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_NAME_EXCEPTION.getMessage());
        }

        List<String> names = Arrays.stream(name.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        NameValidator.validRacingCarName(names);
        return names;
    }
}
