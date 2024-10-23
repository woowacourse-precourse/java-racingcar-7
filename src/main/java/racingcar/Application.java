package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.Input;
import racingcar.domain.TryCount;
import racingcar.service.CarService;
import racingcar.service.impl.CarServiceImpl;
import racingcar.utils.Output;
import racingcar.viewer.Viewer;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();

        CarService carService = new CarServiceImpl(output);
        Viewer viewer = new Viewer(output);
        CarController carController = new CarController(carService, viewer);

        Input input = carController.toInput();
        TryCount tryCount = carController.toTryCount();

        carController.startRace(input, tryCount);

        viewer.print();
    }
}
