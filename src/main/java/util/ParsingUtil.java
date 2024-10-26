package util;

import java.util.Arrays;
import java.util.List;

public class ParsingUtil {
    public static String[] splitCarNames(String input) {
        return input.split(",");
    }

    public static List<String> carNamesToList(String input) {
        return Arrays.asList(splitCarNames(input));  // 배열을 리스트로 변환
    }
}
