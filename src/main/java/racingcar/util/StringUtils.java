package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitByComma(String input) {
        String[] splitInput = input.split(",");  // split 결과를 변수에 저장
        return Arrays.asList(splitInput);
    }
}