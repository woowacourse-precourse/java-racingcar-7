package racingcar.service;

import racingcar.domain.CarList;
import racingcar.domain.CarNameCollect;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;

public interface CarService {

    CarList toCarList(CarNameCollect carNameCollect);

    Winners process(CarList carList, TryCount tryCount);

    void result(Winners winners);

}
