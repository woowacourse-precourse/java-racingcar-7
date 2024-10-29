package racingcar.app.front.controller;

import java.util.List;
import racingcar.app.front.model.InputManager;
import racingcar.app.front.model.OutputManager;
import racingcar.app.middleware.dto.InputDTO;
import racingcar.app.middleware.dto.OutputDTO;

public class FrontController {

    public InputDTO readInputs() {
        InputManager inputManager = InputManager.getInstance();
        List<String> carNames = inputManager.enterCarNames();
        long lapCount = inputManager.enterLapCount();
        return InputDTO.of(carNames, lapCount);
    }

    public void writeOutputs(final OutputDTO outputs) {
        OutputManager outputManager = OutputManager.getInstance();
        outputManager.showRaceResult(outputs);
    }
}
