package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class DefaultConsoleReader implements ConsoleReader{
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
