package racingcar.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.Reader;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        return Console.readLine();
    }

    @Override
    public int readGameNumber() {
        String s = Console.readLine();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("게임 횟수를 입력해야 합니다.");
        }
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수는 숫자가 입력되어야 합니다.");
        }
        return Integer.parseInt(s);
    }
}
