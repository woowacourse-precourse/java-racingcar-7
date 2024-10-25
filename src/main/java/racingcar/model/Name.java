package racingcar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Name(String name) {

    private static final int NAME_MAX_SIZE = 5;
    public static final String NOT_CONTAINS_SPECIAL_CHAR_REGEX = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";

    public Name {
        validateNameIsBlank(name);
        validateNameLengthLongerThenMaxSize(name);
        validateSpecialCharacterIn(name);
    }

    private void validateNameIsBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLengthLongerThenMaxSize(final String name) {
        if (name.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException("이름의 길이는 " + NAME_MAX_SIZE + "자 이하여야 합니다.");
        }
    }

    private void validateSpecialCharacterIn(String carName) {
        Pattern pattern = Pattern.compile(NOT_CONTAINS_SPECIAL_CHAR_REGEX);
        Matcher matcher = pattern.matcher(carName);

        if (matcher.find()) {
            throw new IllegalArgumentException("이름에 특수문자를 사용할 수 없습니다.");
        }
    }
}
