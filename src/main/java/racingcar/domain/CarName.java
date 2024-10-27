package racingcar.domain;

import java.util.regex.Pattern;

public record CarName(String name) {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final Pattern NAME_PATTERN = Pattern.compile("^[가-힣a-zA-Z][가-힣a-zA-Z0-9]*$");

    public CarName {
        validate(name);
    }

    private static void validate(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다");
        }

        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("자동차 이름은 한글 또는 영문으로 시작하고 공백을 포함할 수 없습니다");
        }
    }
}
