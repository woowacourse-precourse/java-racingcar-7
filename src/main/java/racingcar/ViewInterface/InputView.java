package racingcar.ViewInterface;

import java.util.List;

public interface InputView {
    void carNameInput();
    void requestMoveCount();
    List<String> readCarNames();
    String readMoveCount();
}
