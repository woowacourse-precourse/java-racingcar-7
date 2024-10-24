package racingcar;

import java.util.List;

public class SizeValidator {

    private static final Integer MAX_LENGTH = 5;

    // stream 으로 추후 개선
    public void isValid(List<String> values) {
        for (String value : values) {
            if (value.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(String.format("%d 글자 이하만 가능합니다.", MAX_LENGTH));
            }
        }
    }

}
