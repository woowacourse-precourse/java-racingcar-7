package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String read() {
        final String command = Console.readLine();
        Console.close();

        return command;
    }

}
