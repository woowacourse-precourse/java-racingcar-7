package racingcar;

import racingcar.Controller.InputController;
import racingcar.Controller.PlayController;
import racingcar.Model.GameCars;
import racingcar.View.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameCars gameCars = InputController.setCars();
        int gameNumber = InputController.setGameCount();
        GameView gameView = new GameView();


        PlayController playController = new PlayController(gameCars, gameNumber, gameView);
        playController.startGame();
    }
}
