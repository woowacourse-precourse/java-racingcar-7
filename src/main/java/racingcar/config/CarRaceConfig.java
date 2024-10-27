package racingcar.config;

import racingcar.io.InputReceiver;
import racingcar.io.view.View;

public class CarRaceConfig {
    private final View view;
    private final InputReceiver inputReceiver;

    public CarRaceConfig(View view, InputReceiver inputReceiver) {
        this.view = view;
        this.inputReceiver = inputReceiver;
    }

    public View getOutPutView() {
        return view;
    }

    public InputReceiver getInputReceiver() {
        return inputReceiver;
    }
}
