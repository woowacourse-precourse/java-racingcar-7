package racingcar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final int ZERO = 0;
    private static final Pattern pattern = Pattern.compile("^[a-z0-9]{1,5}(,[a-z0-9]{1,5})*$");

    public static void validateNames(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 입력 형식에 맞지 않습니다. 입력 형식 예시: `pobi , woni, jun `");
        }
    }

    public static int parseNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num <= ZERO) {
                throw new IllegalArgumentException("[ERROR] 입력값 범위는 1이상의 자연수 입니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 자연수가 아닙니다.");
        }
    }
}
