package racingcar.controller;

import racingcar.domain.RacingCarService;

import java.util.List;

public class RacingCarController {

    public void run() {
        List<String> userInputs = RacingCarInput.getUserInput();

        RacingCarService racingCarService =
                new RacingCarService(userInputs.get(0), Integer.parseInt(userInputs.get(1)));
    }
}
