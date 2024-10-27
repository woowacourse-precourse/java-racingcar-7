package racingcar.service.impl;

import racingcar.domain.CarList;
import racingcar.domain.Message;
import racingcar.domain.NameCollect;
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
    public CarList toCarList(NameCollect nameCollect) {
        return CarList.from(nameCollect);
    }

    @Override
    public Winners process(CarList carList, TryCount tryCount) {
        // 입력된 횟수만큼 반복하도록 돌아가는 메소드
        while (tryCount.canTry()) {
            carList.moveAll();
            Message allStatus = Message.allStatus(carList);
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
