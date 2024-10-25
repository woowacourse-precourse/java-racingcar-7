package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    static String regex = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    static Pattern pattern = Pattern.compile(regex);
    static Matcher matcher;

    public static void main(String[] args) {
        inputString();
    }

    private static void inputString() {
        String input = Console.readLine();
        matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("문자열이 정규식에 맞습니다.");
        } else {
            System.out.println("문자열이 정규식에 맞지 않습니다.");
        }
    }
}
