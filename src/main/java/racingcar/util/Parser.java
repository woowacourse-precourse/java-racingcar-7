package racingcar.util;

public class Parser {

    public static int parseStringToInt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.");
        }
    }
}
