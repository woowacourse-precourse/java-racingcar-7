package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNameText() {
        return Console.readLine();
    }

    public int readNumberOfTimes() {
        String numberOfTimes = Console.readLine();

        return Integer.parseInt(numberOfTimes);
    }
}
