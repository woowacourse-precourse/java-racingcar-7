package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static String COMMA = ",";

    public List<String> readCarNames() {
        String input = Console.readLine();
        return Arrays.stream(input.split(COMMA)).toList();
    }

    public int readTryCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
