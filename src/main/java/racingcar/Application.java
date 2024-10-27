package racingcar;

import racingcar.controller.Game;
import racingcar.service.GameInput;
import racingcar.service.GamePhase;
import racingcar.service.NameValidator;

public class Application {
    public static void main(String[] args) {
        GameInput gameInput = new GameInput();
        NameValidator nameValidator = new NameValidator();
        GamePhase gamePhase = new GamePhase();

        Game game = new Game(gameInput, nameValidator, gamePhase);
        game.run();
    }
}
