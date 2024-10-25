package racingcar;

import racingcar.controller.Controller;
import racingcar.utils.Utils;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller game = new Controller(new Validator(), new Utils(), new InputView(), new OutputView());
        game.startRace();
    }
}
