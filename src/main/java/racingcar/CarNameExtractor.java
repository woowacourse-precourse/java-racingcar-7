package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNameExtractor {

    private static final String NAME_DELIMITER = ",";

    public CarNameExtractor(String rawString) {
        checkNull(rawString);
        checkBlank(rawString);
    }

    public List<String> extractCarNames(String rawString) {
        List<String> extractedCarNames = new ArrayList<>();
        Collections.addAll(extractedCarNames, rawString.split(NAME_DELIMITER));
        return extractedCarNames;
    }

    private void checkNull(String rawString) {
        if (rawString == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void checkBlank(String rawString) {
        if (rawString.isBlank()) {
            throw new IllegalArgumentException("빈 문자열과 공백은 입력할 수 없습니다.");
        }
    }
}
