package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static final Input instance = new Input();

    private Input() {}

    public static Input getInstance() {
        return instance;
    }

    public String inputString() {
        return Console.readLine();
    }

    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }
}
