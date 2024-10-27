package racingcar;

import racingcar.racingcarController.Controller;
import racingcar.racingcarView.CarView;
import racingcar.racingcarModel.CarModel;

public class Application {
    public static void main(String[] args) {
        CarView carView = new CarView();
        CarModel carModel = new CarModel();
        Controller controller = new Controller(carView, carModel);
        controller.run();


    }

}
