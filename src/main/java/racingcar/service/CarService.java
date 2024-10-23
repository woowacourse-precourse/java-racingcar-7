package racingcar.service;

import racingcar.domain.CarList;
import racingcar.domain.Input;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;

public interface CarService {

    CarList toCarList(Input input);

    Winners process(CarList carList, TryCount tryCount);

    void result(Winners winners);

}
