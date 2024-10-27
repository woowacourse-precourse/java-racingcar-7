package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public String read() {
        return Console.readLine();
    }
}
