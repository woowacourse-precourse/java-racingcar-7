package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        return Console.readLine();
    }

    public String readTryCount() {
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }
}
