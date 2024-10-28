package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarRaceService;
import racingcar.service.InputService;
import racingcar.service.RaceResultService;
import racingcar.view.OutputView;

public class CarRaceController {
    private final InputService inputService;
    private final OutputView outputView;
    private final CarRaceService carRaceService;
    private final RaceResultService raceResultService;

    public CarRaceController(InputService inputService, OutputView outputView, CarRaceService carRaceService, RaceResultService raceResultService) {
        this.inputService = inputService;
        this.outputView = outputView;
        this.carRaceService = carRaceService;
        this.raceResultService = raceResultService;
    }

    public void startRace() {
        List<Car> cars = inputService.getCars();
        int trialCount = inputService.getTrialCount();

        for(int i=0; i<trialCount; i++) {
            carRaceService.performRaceRound(cars);
            outputView.printRaceStatus(cars);
        }

        List<String> winners = raceResultService.determineWinners(cars);
        outputView.printWinners(winners);
    }
}
