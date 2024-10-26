package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String input() {
        return Console.readLine();
    }

    public Long longInput() {
        return Long.parseLong(input());
    }

    public void closeReadLine() {
        Console.close();
    }
}
