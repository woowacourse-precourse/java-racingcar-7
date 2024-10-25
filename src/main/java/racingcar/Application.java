package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        try {
            String carNames = InputView.inputCarNames();
            String tryCount = InputView.inputTryCount();
            RacingResult racingResult = racingCarController.getRacingResult(carNames, tryCount);
            OutputView.printResult(racingResult);
        } finally {
            Console.close();
        }
    }
}
