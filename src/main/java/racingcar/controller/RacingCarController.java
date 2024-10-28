package racingcar.controller;

import java.util.HashSet;
import racingcar.dto.RacingRequestDto;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.service.CarService;
import racingcar.service.RacingService;

public class RacingCarController {

    private final CarService carService;
    private final RacingService racingService;

    public RacingCarController() {
        this.carService = new CarService();
        this.racingService = new RacingService();
    }

    public void run() {
        RacingRequestDto racingRequestDto = racingService.racingSetUpRequest();

        String carNames = racingRequestDto.getCarNames();
        int tryCountNumber = racingRequestDto.getTryCountNumber();

        HashSet<Car> cars = carService.validateCarNames(carNames);

        Racing racing = new Racing();
        racingService.runTotalRoundRacing(cars, tryCountNumber);
        racingService.findRacingWinner(racing, cars);
    }
}
