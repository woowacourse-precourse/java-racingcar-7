package racingcar.view;

import racingcar.util.CommonIo;

public class InputView {
    private CommonIo io = new CommonIo();

    public String receiveCarNames() {
        return io.receiveInput();
    }

    public String receivePlayCount() {
        return io.receiveInput();
    }
}
