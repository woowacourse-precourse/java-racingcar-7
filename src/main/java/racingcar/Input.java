package racingcar;

import org.junit.platform.commons.util.StringUtils;

public class Input {
    public void validateBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }

    public void validateEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("문자열 입력이 필요합니다.");
        }
    }
}