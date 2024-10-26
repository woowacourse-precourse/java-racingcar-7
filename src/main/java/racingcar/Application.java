package racingcar;

import racingcar.Controller.Controller;
import racingcar.View.CarNameView;

public class Application {
    public static void main(String[] args) {
        CarNameView carNameView = new CarNameView();
        Controller controller = new Controller(carNameView);
        controller.run();

    }
}
