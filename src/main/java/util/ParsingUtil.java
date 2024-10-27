package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParsingUtil {
    public static String[] splitCarNames(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim) // 각 문자열의 앞뒤 공백 제거
                .toArray(String[]::new); // 배열로 변환
    }

    public static List<String> carNamesToList(String input) {
        return Arrays.asList(splitCarNames(input));  // 배열을 리스트로 변환
    }

    // 대소문자가 달라도 동일한 입력으로 판단
    public static List<String> DuplicateNames(List<String> carNames) {
        List<String> lowerCaseNames = carNames.stream()
                .map(String::toLowerCase)  // 이름을 소문자로 변환
                .collect(Collectors.toList());
        return lowerCaseNames;
    }
}
