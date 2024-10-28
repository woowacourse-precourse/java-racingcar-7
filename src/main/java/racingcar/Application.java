package racingcar;


import racingcar.controller.MainController;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController controller = new MainController(new InputView(), new OutputView(), new Validator());
        controller.run();
    }
}
