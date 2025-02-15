package racingcar;

import racingcar.controller.Controller;
import racingcar.service.CarService;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        CarService carService = new CarService();
        Controller controller = new Controller(view, carService);
        controller.run();
    }
}
