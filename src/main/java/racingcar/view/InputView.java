package racingcar.view;

import racingcar.util.CommonIo;

public class InputView {
    private final CommonIo io;

    public InputView() {
        this.io = new CommonIo();
    }

    public String receiveCarNames() {
        String original = io.receiveInput();
        return io.removeWhiteSpace(original);
    }

    public String receivePlayCount() {
        return io.receiveInput();
    }
}
