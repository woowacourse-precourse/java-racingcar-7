package util;

import java.util.Arrays;
import java.util.List;

public class ParsingUtil {
    public static String[] splitCarNames(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim) // 각 문자열의 앞뒤 공백 제거
                .toArray(String[]::new); // 배열로 변환
    }

    public static List<String> carNamesToList(String input) {
        return Arrays.asList(splitCarNames(input));  // 배열을 리스트로 변환
    }
}
