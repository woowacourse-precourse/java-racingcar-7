package racingcar.view;

import racingcar.util.io.InputConsole;

public class InputView {

    public String getCarNames() {
        return InputConsole.readLine();
    }

    public long getTryCount() {
        return Long.parseLong(InputConsole.readLine());
    }
}
