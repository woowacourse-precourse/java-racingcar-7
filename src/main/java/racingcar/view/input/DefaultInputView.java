package racingcar.view.input;

import racingcar.exception.ExceptionFactory;
import racingcar.util.io.InputConsole;

import java.util.List;

import static racingcar.exception.ExceptionType.INVALID_TRY_COUNT;

public class DefaultInputView implements InputView {

    public List<String> getCarNames() {
        return List.of(InputConsole.readLine().split(","));
    }

    public int getTryCount() {
        try {
            return Integer.parseInt(InputConsole.readLine());
        } catch (NumberFormatException e) {
            throw ExceptionFactory.createException(INVALID_TRY_COUNT);
        }
    }
}
