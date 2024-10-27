package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.input.InputView;

public class ConsoleInputView implements InputView {
    @Override
    public String read() {
        return Console.readLine();
    }
}
