package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    static String regex = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    static Pattern pattern = Pattern.compile(regex);
    static Matcher matcher;

    public static void inputString() {
        String input = Console.readLine();

        isCorrectInput(input);
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
