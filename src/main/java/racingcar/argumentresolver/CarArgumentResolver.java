package racingcar.argumentresolver;

import java.util.Arrays;
import java.util.List;

public class CarArgumentResolver implements ArgumentResolver<List<String>> {

    private static final int NEGATIVE = -1;

    @Override
    public List<String> parse(String parameter) {
        checkBlank(parameter);
        return splitWithBlankAndTrim(parameter);
    }

    private List<String> splitWithBlankAndTrim(String parameter) {
        return Arrays.stream(parameter.split(",", NEGATIVE))
                .map(String::trim)
                .toList();
    }

    private void checkBlank(String parameter) {
        if (parameter == null || parameter.isBlank()) {
            throw new IllegalArgumentException("비어있는 입력은 불가능합니다.");
        }
    }

}
