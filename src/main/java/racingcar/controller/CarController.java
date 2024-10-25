package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.Input;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.service.CarService;
import racingcar.viewer.Viewer;

public class CarController {

    private final CarService carService;
    private final Viewer viewer;

    public CarController(CarService carService, Viewer viewer) {
        this.carService = carService;
        this.viewer = viewer;
    }

    public Input toInput() {
        viewer.printInputCarNames();
        String carNames = viewer.readCarNames();

        return new Input(carNames);
    }

    public TryCount toTryCount() {
        viewer.printTryCount();
        String countStr = viewer.readTryCount();

        return new TryCount(countStr);
    }

    public void startRace(Input input, TryCount tryCount) {
        CarList carList = carService.toCarList(input);
        Winners winners = carService.process(carList, tryCount);
        carService.result(winners);
    }
}
