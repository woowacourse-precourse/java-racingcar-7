package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputFormatter {

    // 입력 문자열을 쉼표로 분리한 후 각 요소의 공백을 제거하여 문자열 반환
    public static String trimInput(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .collect(Collectors.joining(","));
    }

    // 입력 문자열을 쉼표로 분리하여 자동차 이름 리스트 반환
    public static List<String> parseCarNames(String inputString) {
        return Arrays.asList(inputString.split(",", -1)); // trim을 여기서는 적용하지 않음-> ',,'인 경우를 구별하기 위함
    }
}
