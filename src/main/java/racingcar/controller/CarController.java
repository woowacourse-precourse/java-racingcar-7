package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceRecord;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public CarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carService = new CarService();
    }

    public void run() {
        List<Car> cars = carService.createCars(inputView.getInputName(), inputView.getInputTimes());
        outputView.printRace(cars);
        RaceRecord raceRecord = new RaceRecord(cars);
        outputView.printWinners(raceRecord.calculateWinners());
    }
}
