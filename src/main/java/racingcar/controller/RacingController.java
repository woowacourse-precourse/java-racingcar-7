package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.service.WinnerService;
import racingcar.validator.Validator;
import racingcar.validator.impl.NameValidator;
import racingcar.validator.impl.NumberValidator;

public class RacingController {
    CarService carService;
    RacingService racingService;
    WinnerService winnerService;

    public RacingController() {
        this.carService = new CarService();
        this.racingService = new RacingService();
        this.winnerService = new WinnerService();
    }

    public void run() {
        carService.inputRacingCar();
        racingService.race();
        winnerService.printWinners();
    }
}
