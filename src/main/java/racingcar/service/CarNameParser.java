package racingcar.service;

import racingcar.common.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private final String input;
    private final static int MAX_CAR_NAME_LENGTH = 5;

    public CarNameParser(String input) {
        this.input = input;
    }

    public List<String> parse() {
        return Arrays.stream(input.split(","))
            .map(s -> {
                s = s.trim(); // 공백 제거
                validateNameLengthOrThrow(s);
                return s;
            })
            .toList();
    }

    private void validateNameLengthOrThrow(String s) {
        if (s.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_CAR_NAME_LENGTH);
        }
    }
}
