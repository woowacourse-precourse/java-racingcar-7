package racingcar.service.impl;

import racingcar.domain.CarList;
import racingcar.domain.Input;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.service.CarService;
import racingcar.utils.Output;

public class CarServiceImpl implements CarService {

    private final Output output;

    public CarServiceImpl(Output output) {
        this.output = output;
    }

    @Override
    public CarList toCarList(Input input) {
        return CarList.from(input);
    }

    @Override
    public Winners process(CarList carList, TryCount tryCount) {

        // 입력된 횟수만큼 반복하도록 돌아가는 메소드
        while (tryCount.canTry()) {
            carList.moveAll();
            String status = carList.generateStatus();
            output.append(status);
        }

        return Winners.from(carList);
    }

    @Override
    public void result(Winners winners) {
        String result = winners.result();
        output.append(result);
    }
}
