package racingcar.service.impl;

import racingcar.domain.CarList;
import racingcar.domain.CarNameCollect;
import racingcar.domain.Message;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.service.CarService;
import racingcar.viewer.Output;

public class CarServiceImpl implements CarService {

    private final Output output;

    public CarServiceImpl(Output output) {
        this.output = output;
    }

    @Override
    public CarList toCarList(CarNameCollect carNameCollect) {
        return CarList.from(carNameCollect);
    }

    @Override
    public Winners process(CarList carList, TryCount tryCount) {
        while (tryCount.canTry()) {
            carList.moveAll();
            Message allStatus = Message.statusAll(carList);
            output.append(allStatus);
        }

        return Winners.from(carList);
    }

    @Override
    public void result(Winners winners) {
        Message result = Message.result(winners);
        output.append(result);
    }
}
