package racingcar;

import java.util.List;

public class SizeValidator {

    private static final Integer MIN_LENGTH = 0;
    private static final Integer MAX_LENGTH = 5;

    public void check(List<String> values) {
        if (haveNotValidSizeValue(values)) {
            throw new IllegalArgumentException(String.format("%d자 초과, %d자 이하만 가능합니다.", MIN_LENGTH, MAX_LENGTH));
        }
    }

    private boolean haveNotValidSizeValue(List<String> values) {
        return values.stream()
                .anyMatch(this::isNotValidSize);
    }

    private boolean isNotValidSize(String value) {
        return MIN_LENGTH >= value.length() || value.length() > MAX_LENGTH;
    }

}
