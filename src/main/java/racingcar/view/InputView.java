package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    public String inputStringWithoutSpaces() {
        return Console.readLine().replace(SPACE, EMPTY_STRING);
    }
}
