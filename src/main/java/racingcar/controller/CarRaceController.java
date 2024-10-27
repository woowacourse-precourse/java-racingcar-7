package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarRaceService;
import racingcar.service.RaceResultService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    private CarRaceService carRaceService;
    private RaceResultService raceResultService;
    private InputView inputView;
    private OutputView outputView;
    private List<Car> cars;

    public CarRaceController(CarRaceService carRaceService, InputView inputView, OutputView outputView, RaceResultService raceResultService) {
        this.carRaceService = carRaceService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceResultService = raceResultService;
    }

    public void startRace() {
        String carNamesInput = inputView.getCarNames();
        cars = createCars(carNamesInput);

        int trialCount = inputView.getTrialCount();
        for(int i=0; i<trialCount; i++) {
            carRaceService.performRaceRound(cars);
            outputView.printRaceStatus(cars);
        }
        List<String> winners = raceResultService.determineWinners(cars);
        outputView.printWinners(winners);
    }

    private List<Car> createCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNamesInput.split(",")) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
