package racingcar.model.vo;

import org.junit.platform.commons.util.StringUtils;

public record Name(String value) {

    private static final int NAME_MAX_LENGTH = 5;

    public Name {
        validateNameValue(value);
        validateNameLength(value);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없습니다.");
        }
    }

    private void validateNameValue(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
    }
}
