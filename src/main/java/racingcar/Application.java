package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.domain.MoveCount;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        InputController inputController = appConfig.inputController();
        inputController.postNames();

        MoveCount moveCount = inputController.getMoveCount();

        GameController gameController = appConfig.gameController();
        gameController.executeRace(moveCount);

        
    }
}
