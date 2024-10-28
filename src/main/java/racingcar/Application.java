package racingcar;

import racingcar.racingcarController.Controller;
import racingcar.racingcarController.ExceptionController;
import racingcar.racingcarView.CarView;

public class Application {
    public static void main(String[] args) {
        CarView carView = new CarView();
        ExceptionController ExceptionController = new ExceptionController();

        Controller controller = new Controller(carView, ExceptionController);
        controller.run();


    }

}
