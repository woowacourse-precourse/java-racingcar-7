package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.NameCollect;
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

    public NameCollect toNameCollect() {
        viewer.printInputCarNames();
        String carNames = viewer.readCarNames();

        return NameCollect.create(carNames);
    }

    public TryCount toTryCount() {
        viewer.printTryCount();
        String countStr = viewer.readTryCount();

        return TryCount.create(countStr);
    }

    public void startRace(NameCollect nameCollect, TryCount tryCount) {
        CarList carList = carService.toCarList(nameCollect);
        Winners winners = carService.process(carList, tryCount);
        carService.result(winners);
    }
}
