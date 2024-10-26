package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputTry {

    public InputTry() { }

    public int input() {
        String tryToString = Console.readLine();
        int tries = Integer.parseInt(tryToString);
        return tries;
    }
}
