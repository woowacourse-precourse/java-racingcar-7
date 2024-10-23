package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    static List<String> parse(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::strip) // 각 요소의 앞뒤 공백 제거
                .toList();
    }
}
