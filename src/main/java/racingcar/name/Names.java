package racingcar.name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {

    private static final String COMMA = ",";
    private static final String CONSECUTIVE_COMMAS = ",,";
    private static final String INPUT_IS_EMPTY_MESSAGE = "문자열이 입력되지 않았습니다.";
    private static final String CAN_BE_NO_CONSECUTIVE_COMMAS_MESSAGE = "연속된 쉼표(,)는 입력될 수 없습니다.";
    private static final String SINGLE_NAME_ERROR_MESSAGE = "하나의 이름만 들어갈 수는 없습니다.";
    private static final String INPUT_CANT_HAVE_DUPLICATED_NAME_MESSAGE = "이름은 중복될 수 없습니다.";

    private final List<Name> names;

    public Names(String input) {
        this.names = initializeNames(input);
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public List<Name> initializeNames(String input) {
        validateEmptyString(input);
        validateConsecutiveComma(input);

        List<String> splitNameList = List.of(input.split(COMMA));
        List<Name> nameList = new ArrayList<>();

        for (String nameString : splitNameList) {
            String trimName = nameString.trim();
            append(nameList, trimName);
        }

        checkMinimumSize(nameList);
        return nameList;
    }

    private void validateEmptyString(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_MESSAGE);
        }
    }

    private void validateConsecutiveComma(String input) {
        if (input.contains(CONSECUTIVE_COMMAS)) {
            throw new IllegalArgumentException(CAN_BE_NO_CONSECUTIVE_COMMAS_MESSAGE);
        }
    }

    private void validateDuplicatedName(List<Name> nameList, Name name) {
        if (nameList.contains(name)) {
            throw new IllegalArgumentException(INPUT_CANT_HAVE_DUPLICATED_NAME_MESSAGE);
        }
    }

    private void append(List<Name> nameList, String nameString) {
        Name name = new Name(nameString);

        validateDuplicatedName(nameList, name);

        nameList.add(name);
    }

    private void checkMinimumSize(List<Name> nameList) {
        if (nameList.size() == 1) {
            throw new IllegalArgumentException(SINGLE_NAME_ERROR_MESSAGE);
        }
    }
}
