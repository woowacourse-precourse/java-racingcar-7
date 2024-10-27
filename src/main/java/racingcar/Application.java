package racingcar;

import racingcar.game.RacingGame;
import racingcar.input.InputDTO;
import racingcar.input.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputDTO inputDTO = InputHandler.receiveValidateInput();

        RacingGame racingGame = new RacingGame(inputDTO);
        racingGame.startGame();
    }
}
