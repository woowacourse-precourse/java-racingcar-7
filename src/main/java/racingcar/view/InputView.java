package racingcar.view;

import racingcar.util.CommonIo;

public class InputView {
    private CommonIo io = new CommonIo();

    public String receiveCarNames() {
        String original = io.receiveInput();
        return io.removeWhiteSpace(original);
    }

    public String receivePlayCount() {
        return io.receiveInput();
    }
}
