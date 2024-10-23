package racingcar.utils;

public class Utils {

    public static int parseNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num <= 0) {
                throw new IllegalArgumentException("[ERROR] 입력값 범위는 1이상의 자연수 입니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 자연수가 아닙니다.");
        }
    }
}
