package racingcar.service.impl;

import racingcar.entity.CarList;
import racingcar.entity.Input;
import racingcar.entity.TryCount;
import racingcar.entity.Winners;
import racingcar.service.CarService;

public class CarServiceImpl implements CarService {

    @Override
    public CarList toCarList(Input input) {
        return input.toCarList();
    }

    @Override
    public Winners process(CarList carList, TryCount tryCount) {

        while (tryCount.canTry()) {
            carList.moveAll();
            carList.printAll();
        }

        return carList.toWinners();
    }

    @Override
    public void result(Winners winners) {
        winners.print();
    }
}
