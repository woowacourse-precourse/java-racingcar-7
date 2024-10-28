package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.Constants;

public class StringSplitter {

    private StringSplitter() {

    }

    public static List<String> splitByDelimiter(String UserInput) {
        String[] splittedUserInput = UserInput.split(Constants.DELIMITER);
        return Arrays.stream(splittedUserInput).toList();
    }
}
