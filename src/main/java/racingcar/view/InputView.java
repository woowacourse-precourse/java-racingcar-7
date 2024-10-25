package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {

    private static final String COMMA_DELIMITED_NAME_REGEX = "^[a-zA-Z0-9가-힣]+(,[a-zA-Z0-9가-힣]+)*$";

    public static String inputCarNames() {
        String input = Console.readLine();
        validateCommaDelimitedNames(input);
        return input;
    }

    private static void validateCommaDelimitedNames(String input) {
        if (!Pattern.matches(COMMA_DELIMITED_NAME_REGEX, input)) {
            throw new IllegalArgumentException("입력받은 자동차 이름은 쉼표(,)로 구분되어야 하고 반드시 알파벳, 숫자 또는 한글로 이루어져야 합니다.");
        }
    }
}
