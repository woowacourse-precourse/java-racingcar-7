package racingcar.config;

import racingcar.io.InputReceiver;
import racingcar.io.view.OutPutView;

public class CarRaceConfig {
    private final OutPutView outPutView;
    private final InputReceiver inputReceiver;

    public CarRaceConfig(OutPutView outPutView, InputReceiver inputReceiver) {
        this.outPutView = outPutView;
        this.inputReceiver = inputReceiver;
    }

    public OutPutView getOutPutView() {
        return outPutView;
    }

    public InputReceiver getInputReceiver() {
        return inputReceiver;
    }
}
