package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.service.GameService;
import racingcar.view.InputView;

public class InputController {

    private static Input input = new Input("", 0);
    private static Game game = new Game();
    private static final GameService gameService = new GameService(input);

    public static void run() {
        InputView.getStringInput(input);
        InputView.getCountInput(input);
        gameService.run();
    }
}
