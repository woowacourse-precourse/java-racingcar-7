package racingcar.view;

import racingcar.util.io.InputConsole;

public class InputView {

    public String getCarNames() {
        return InputConsole.readLine();
    }

    public int getTryCount() {
        try {
            return Integer.parseInt(InputConsole.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수입니다.");
        }
    }
}
