package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputCarNames() {
        try {
            return Console.readLine();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
