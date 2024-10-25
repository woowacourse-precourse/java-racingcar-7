package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    static String regex = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    static Pattern pattern = Pattern.compile(regex);
    static Matcher matcher;

    public static String inputString(String input) {
        matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return "문자열이 정규식에 맞습니다.";
        } else {
            return "문자열이 정규식에 맞지 않습니다.";
        }
    }
}
