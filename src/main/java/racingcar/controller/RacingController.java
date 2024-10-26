package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.service.WinnerService;
import racingcar.view.CarView;
import racingcar.view.NumberView;
import racingcar.view.WinnersView;

public class RacingController {
    CarRepository carRepository;

    CarService carService;
    RacingService racingService;
    WinnerService winnerService;

    CarView carView;
    NumberView numberView;
    WinnersView winnersView;

    public RacingController(CarRepository carRepository) {
        this.carRepository = carRepository;

        this.carService = new CarService(this.carRepository);
        this.racingService = new RacingService(this.carRepository);
        this.winnerService = new WinnerService(this.carRepository);

        this.carView = new CarView();
        this.numberView = new NumberView();
        this.winnersView = new WinnersView();
    }

    public void run() {
        String rawNames = carView.inputNames();
        carService.saveAllByString(rawNames);

        String rawNumber = numberView.input();
        racingService.race(rawNumber);

        List<Car> winners = winnerService.getWinners();
        winnersView.print(winners);
    }
}
