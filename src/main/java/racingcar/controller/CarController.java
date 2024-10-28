package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.CarNameCollect;
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

    public CarNameCollect toCarNameCollect() {
        viewer.promptForCarNames();
        String carNames = viewer.readCarNames();

        return CarNameCollect.create(carNames);
    }

    public TryCount toTryCount() {
        viewer.promptForTryCount();
        String countStr = viewer.readTryCount();

        return TryCount.create(countStr);
    }

    public void startRace(CarNameCollect carNameCollect, TryCount tryCount) {
        CarList carList = carService.toCarList(carNameCollect);
        Winners winners = carService.process(carList, tryCount);
        carService.result(winners);
    }
}
