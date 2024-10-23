package racingcar.controller;

import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationController {

    public static void run(InputView inputView, OutputView outputView) {
        InputDTO inputDTO = inputView.display();
        OutputDTO outputDTO = RacingController.execute(inputDTO);
        outputView.display(inputDTO.getTotalTrialCount(), outputDTO);
    }
}