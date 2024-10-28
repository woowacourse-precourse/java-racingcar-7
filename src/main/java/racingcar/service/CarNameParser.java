package racingcar.service;

import racingcar.common.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    private final String input;

    public CarNameParser(String input) {
        this.input = input;
    }

    public List<String> parse() {
        return Arrays.stream(input.split(","))
            .map(s -> {
                s = s.trim(); // 공백 제거
                if (s.length() > 5) {
                    throw new IllegalArgumentException(ErrorMessage.EXCEED_CAR_NAME_LENGTH);
                }
                return s;
            })
            .toList();
    }
}
