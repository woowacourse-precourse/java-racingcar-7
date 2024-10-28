package racingcar;

import racingcar.domain.Car;
import racingcar.service.InputService;
import racingcar.service.RacingService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputService inputService = InputService.getInstance();
        RacingService racingService = RacingService.getInstance();

        List<String> names = inputService.getNames();
        int count = inputService.getTryCount();

        List<Car> cars = racingService.initializeCars(names);
    }
}
