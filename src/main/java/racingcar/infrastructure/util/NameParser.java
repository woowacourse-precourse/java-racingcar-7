package racingcar.infrastructure.util;

import racingcar.presentation.enums.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    private final NameValidator nameValidator = new NameValidator();

    // TODO : ',' 로 이름 구별하기
    public List<String> parsingName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_NAME_EXCEPTION.getMessage());
        }

        List<String> names = Arrays.stream(name.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        nameValidator.validRacingCarName(names);
        return names;
    }
}
