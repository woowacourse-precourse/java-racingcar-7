package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.Input;
import racingcar.utils.Output;
import racingcar.domain.TryCount;
import racingcar.service.CarService;
import racingcar.service.impl.CarServiceImpl;
import racingcar.viewer.Viewer;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();

        CarService carService = new CarServiceImpl(output);
        CarController carController = new CarController(carService);
        Viewer viewer = new Viewer(output);

        Input input = carController.toInput();
        TryCount tryCount = carController.toTryCount();

        carController.startRace(input, tryCount);

        viewer.print();
    }
}
