package racingcar.controller;

import racingcar.dto.RacingAttemptDTO;
import racingcar.dto.RacingCarNamesDTO;
import racingcar.dto.ResultDTO;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void run(){
        RacingCarNamesDTO racingCarNames = getCarsName();
        RacingAttemptDTO racingAttemptDTO = getAttempts();

        ResultDTO resultDTO = RacingGameService.runGame(racingCarNames, racingAttemptDTO);
    }
    private static RacingCarNamesDTO getCarsName(){
        OutputView.requireCarsName();
        return new RacingCarNamesDTO(InputView.inputString());
    }

    private static RacingAttemptDTO getAttempts(){
        OutputView.requireNumberOfAttempts();
        return new RacingAttemptDTO(InputView.inputString());
    }
}
