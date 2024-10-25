package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    static String regex = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    static Pattern pattern = Pattern.compile(regex);
    static Matcher matcher;

    public static void inputString() {
        String input = Console.readLine();

        if (isCorrectInput(input)) {
            isTheLengthOfStringLessThanFive(input);
        }
        else throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static boolean isTheLengthOfStringLessThanFive(String input) {
        String[] cars = input.split(",");

        for (String car : cars) {
            if (car.length() > 5) throw new IllegalArgumentException("이름의 길이가 5자 초과입니다.");
        }
        return true;
    }

    public static boolean isCorrectInput(String inputString) {
        matcher = pattern.matcher(inputString);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
