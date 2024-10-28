package racingcar;

import racingcar.controller.GameController;
import racingcar.model.GameModel;
import racingcar.view.NameInputView;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameModel gameModel = new GameModel();
        View view = new NameInputView();

        GameController controller = new GameController(gameModel, view);

        controller.run();
    }
}
