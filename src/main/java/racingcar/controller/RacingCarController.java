package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService = new RacingCarServiceImpl();

    public List<String> start(int repeatNumber, List<Car> cars) {
        return racingCarService.startRacing(repeatNumber, cars);
    }
}
