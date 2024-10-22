package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private InputView() {
    }

    public static String inputCarNames() {
        String input = Console.readLine();
        return input;
    }

    public static List<String> splitStringByDelimiters(String s, String delimiters) {
        List<String> tokens = List.of(s.split(delimiters));
        return tokens;
    }

    public static String removeSpace(String input) {
        return input.replaceAll("\\s+", "");
    }
}
