package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;

public class CarNamesInputConverter {
    private static final String DELIMITER = ",";


    private CarNamesInputConverter() {
    }

    public static List<String> convert(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.(빈문자열)");
        }

        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
