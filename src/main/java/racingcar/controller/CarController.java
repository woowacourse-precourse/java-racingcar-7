package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;
import racingcar.domain.CarList;
import racingcar.domain.Input;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.service.CarService;

public class CarController {

    // 이름을 입력받고
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public Input toInput() {
        String carName = Console.readLine();

        return new Input(carName);
    }

    public TryCount toTryCount() {
        String countStr = Console.readLine();

        return new TryCount(countStr);
    }

    public void startRace(Input input, TryCount tryCount) {
        CarList carList = carService.toCarList(input);
        Winners winners = carService.process(carList, tryCount);
        carService.result(winners);
    }
}
