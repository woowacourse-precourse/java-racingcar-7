package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.service.GameService;
import racingcar.service.InputService;
import racingcar.view.GameView;

public class InputController {

    private static Game game;
    private static Input input;
    private static GameView gameView;

    private static final InputService inputService = new InputService();
    private static GameService gameService = new GameService(input, game, gameView);

    public static void run() {
        inputService.run();
        gameService.addCarName();
    }
}
