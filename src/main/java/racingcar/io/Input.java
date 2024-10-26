package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final Input instance = new Input();

    private Input() {}

    public static Input getInstance() {
        return instance;
    }

    public String inputString() {
        return Console.readLine();
    }
}
