package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String DELIMITER_ERROR_MESSAGE = "올바른 구분자를 입력해야 합니다.";

    private static final String DELIMITER = ",";
    private static final String OTHER_DELIMITER_REGEX = "[^,\\w\\s]";

    public static String[] getCarNames() {
        String input = Console.readLine();
        validateDelimiter(input);
        String[] carNames = input.split(DELIMITER);
        return carNames;
    }

    private static void validateDelimiter(final String input) {
        Pattern pattern = Pattern.compile(OTHER_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE);
        }
    }
}
