package racingcar.validator;

import java.util.HashSet;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력값이 비었습니다.";
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 입력값이 최대 글자수(5자)를 초과하였습니다.";
    private static final String DUPLICATED_ERROR_MESSAGE = "[ERROR] 입력값 중에 중복된 이름이 있습니다.";
    private static final Integer INITIAL_NUMBER = 0;
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNameBlank(List<String> names) throws IllegalArgumentException {
        names.stream()
                .filter(name -> name.length() == INITIAL_NUMBER)
                .findAny()
                .ifPresent(name -> { throw new IllegalArgumentException(BLANK_ERROR_MESSAGE); });

    }

    public static void validateCarNameLength(List<String> names) throws IllegalArgumentException {
        names.stream()
                .filter(name -> name.length() > MAX_CAR_NAME_LENGTH)
                .findAny()
                .ifPresent(name -> { throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE); } );
    }

    public static void validateDuplicatedCarName(List<String> names) throws IllegalArgumentException {
        Set<String> nameSet = new HashSet<>(names);
        if(nameSet.size() != names.size())
            throw new IllegalArgumentException(DUPLICATED_ERROR_MESSAGE);
    }
}
