package racingcar.client.controller;

import java.util.List;
import racingcar.client.model.InputManager;
import racingcar.client.model.OutputManager;
import racingcar.middleware.dto.InputDTO;
import racingcar.middleware.dto.OutputDTO;

public class FrontController {

    public InputDTO readInputs() {
        InputManager inputManager = InputManager.getInstance();
        List<String> carNames = inputManager.enterCarNames();
        long lapCount = inputManager.enterLapCount();
        return InputDTO.of(carNames, lapCount);
    }

    public void writeOutputs(final OutputDTO outputs) {
        OutputManager outputManager = OutputManager.getInstance();
        outputManager.showLapCharts(outputs.lapCharts());
        outputManager.showWinners(outputs.winners());
    }
}
