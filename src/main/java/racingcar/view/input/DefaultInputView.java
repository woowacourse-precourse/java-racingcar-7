package racingcar.view.input;

import racingcar.util.io.InputConsole;

import java.util.List;

public class DefaultInputView implements InputView {

    public List<String> getCarNames() {
        return List.of(InputConsole.readLine().split(","));
    }

    public int getTryCount() {
        try {
            return Integer.parseInt(InputConsole.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수입니다.");
        }
    }
}
