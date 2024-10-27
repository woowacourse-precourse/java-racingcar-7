package racingcar.util;

import racingcar.controller.RacingCarController;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RacingCarResponse;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarRunner {
    private static final RacingCarController RACING_CATR_CONTROLLER = new RacingCarController(new RacingCarService());

    public static void run() {
        RacingCarRequest input = InputView.input();

        RacingCarResponse racingCarResponse = RACING_CATR_CONTROLLER.processInput(input);

        OutputView.printOutput(racingCarResponse);
    }
}