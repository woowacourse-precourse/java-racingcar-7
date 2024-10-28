package racingcar;

import input.CarNameInput;
import input.MoveInput;
import java.util.List;
import racingGame.WholeCycleGame;

public class Application {
    public static void main(String[] args) {
        CarNameInput carNameInput = new CarNameInput();
        MoveInput moveInput = new MoveInput();

        List<String> participateCarList = carNameInput.inputHandler();
        int numberOfMove = moveInput.inputHandler();

        WholeCycleGame wholeCycleGame = new WholeCycleGame();

        wholeCycleGame.gameStart(participateCarList, numberOfMove);
    }
}
