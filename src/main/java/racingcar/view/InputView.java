package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";

    public static List<String> carNames() {
        return splitNames(Console.readLine());
    }

    public static List<String> splitNames(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }
}
