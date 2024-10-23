package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.handler.InputHandler;
import racingcar.service.RacingGameService;

public class MainController {

    private final RacingGameService racingGameService;
    private final InputHandler inputHandler;

    public MainController() {
        this.racingGameService = new RacingGameService();
        this.inputHandler = new InputHandler();
    }

    public void gameStart() {
        List<String> carNames = inputHandler.getCarNames();
        int tryCount = inputHandler.getTryCount();
        racingGameService.startRace(carNames, tryCount);
    }
}
