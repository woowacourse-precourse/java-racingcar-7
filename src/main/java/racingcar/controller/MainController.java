package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.service.RacingGameService;

import java.util.List;

public class MainController {

    private final RacingGameService racingGameService;
    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;

    public MainController() {
        this.outputHandler = new OutputHandler();
        this.racingGameService = new RacingGameService();
        this.inputHandler = new InputHandler();
    }

    public void gameStart() {
        List<String> carNames = inputHandler.getCarNames();
        int tryCount = inputHandler.getTryCount();

        System.out.println();

        outputHandler.gameResult(racingGameService.startRace(carNames, tryCount));

    }
}
