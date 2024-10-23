package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    static List<String> parse(String input, String delimiter) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어있습니다.");
        }

        List<String> result = Arrays.stream(input.split(delimiter))
                    .map(String::strip)
                    .toList();

        // 빈 문자열만 들어온 경우
        if (result.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 자동차 이름으로 사용할 수 없습니다.");
        }
        // 빈 문자열과 쉼표만 들어온 경우
        boolean hasEmptyName = result.stream().anyMatch(String::isEmpty);
        if (hasEmptyName) {
            throw new IllegalArgumentException("빈 문자열은 자동차 이름으로 사용할 수 없습니다.");
        }

        return result;
    }
}
