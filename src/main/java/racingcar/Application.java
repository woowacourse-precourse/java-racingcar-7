package racingcar;

import racingcar.controller.GameController;
import racingcar.factory.CarRacingFactory;
import racingcar.validate.Validator;
import racingcar.view.PrintHelper;
import racingcar.view.ReaderHelper;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new ReaderHelper(), new PrintHelper(),
                new Validator(), new CarRacingFactory());
        gameController.run();
    }
}
