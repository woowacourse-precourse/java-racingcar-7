package racingcar.application.util.io;

import camp.nextstep.edu.missionutils.Console;

import racingcar.application.util.io.vo.Input;
import racingcar.application.util.validator.InputValidator;

import java.util.List;
import java.util.ArrayList;

public final class InputReader {

    private static final String AVAILABLE_NAME_SEPARATOR = ",";

    private InputReader() {}

    public static List<String> readCarNames() {
        Input input = new Input(Console.readLine());
        InputValidator.validateNamesInput(input);

        List<String> names = new ArrayList<>();
        for (String name : input.value().split(AVAILABLE_NAME_SEPARATOR)) {
            names.add(name.trim());
        }
        return names;
    }

    public static long readTrial() {
        Input input = new Input(Console.readLine());
        InputValidator.validateTrialInput(input);

        return Long.parseLong(input.value());
    }

}
