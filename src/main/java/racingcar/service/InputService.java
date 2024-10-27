package racingcar.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.view.InputView;

public class InputService {

    static String regex = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
    static Pattern pattern = Pattern.compile(regex);
    static Matcher matcher;

    private final InputView inputView = new InputView();

    public static boolean isTheLengthOfStringLessThanFive(String input) {
        String[] cars = input.split(",");

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("이름의 길이가 5자 초과입니다.");
            }
        }

        return true;
    }

    public static boolean isCorrectInput(String inputString) {
        matcher = pattern.matcher(inputString);
        return matcher.matches();
    }
}
