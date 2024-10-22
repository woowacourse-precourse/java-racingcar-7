package racingcar.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Reader;

public class ConsoleRead implements Reader {

    @Override
    public String readOrigin() {
        return Console.readLine();
    }

    @Override
    public int readGameNumber() {
        String s = Console.readLine();
        return Integer.parseInt(s);
    }
}
