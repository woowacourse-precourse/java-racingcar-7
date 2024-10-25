package racingcar.service;

import racingcar.domain.CarList;
import racingcar.domain.NameCollect;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;

public interface CarService {

    CarList toCarList(NameCollect nameCollect);

    Winners process(CarList carList, TryCount tryCount);

    void result(Winners winners);

}
