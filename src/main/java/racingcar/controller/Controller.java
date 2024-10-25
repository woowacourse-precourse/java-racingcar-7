package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class Controller {

    private final RacingGameService service = new RacingGameService();

    public void run() {
        InputView.printRequestCarNamesMessage();
        String carNames = Console.readLine();
        InputView.printRequestLoopCount();
        String loopCount = Console.readLine();
    }
}
