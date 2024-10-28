package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarIO;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final RacingCarIO racingCarIO;

    public RacingCarController() {
        this.racingCarService = new RacingCarService();
        this.racingCarIO = new RacingCarIO();
    }

    public void defineInitialPosition() {
        String carInfo = racingCarIO.getCarInfo();
        racingCarService.getCarList(carInfo);

        String tryCountStr = racingCarIO.tryCountInfo();
        racingCarService.getTryCount(tryCountStr);
    }

    public void calculate() {
        racingCarService.calculateRandomNumber();
    }

    public void getResult() {
        List<Car> carList = racingCarService.getAllCarList();
        List<String> winners = racingCarService.calculateWinner();

        racingCarIO.printResult(carList);
        racingCarIO.printWinners(winners);
    }
}
