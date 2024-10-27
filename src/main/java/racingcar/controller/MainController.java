package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.service.RacingGameService;

import java.util.List;

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
        System.out.println();
        racingGameService.startRace(carNames, tryCount);
    }
}
