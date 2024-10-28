package racingcar;

import racingcar.Controller.Controller;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            Controller controller = new Controller(inputView, outputView);

            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}