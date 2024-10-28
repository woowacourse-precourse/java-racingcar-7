package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readInput() {
        return readLine();
    }

    public static void closeRead() {
        Console.close();
    }
}
