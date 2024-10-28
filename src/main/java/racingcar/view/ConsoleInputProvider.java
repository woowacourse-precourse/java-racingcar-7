package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputProvider implements InputProvider {
    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
