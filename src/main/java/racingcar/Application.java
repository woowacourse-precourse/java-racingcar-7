package racingcar;

import racingcar.racingcarController.Controller;
import racingcar.racingcarModel.ExceptionModel;
import racingcar.racingcarView.CarView;
import racingcar.racingcarModel.CarModel;

public class Application {
    public static void main(String[] args) {
        CarView carView = new CarView();
        CarModel carModel = new CarModel();
        ExceptionModel exceptionModel = new ExceptionModel();

        Controller controller = new Controller(carView, carModel, exceptionModel);
        controller.run();


    }

}
