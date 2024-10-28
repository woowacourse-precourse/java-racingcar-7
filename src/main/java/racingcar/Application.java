package racingcar;

import racingcar.Controller.Controller;
import racingcar.model.Movement;
import racingcar.model.RandomMovement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Movement movement = new RandomMovement();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView, movement);
        controller.run();
    }
}
