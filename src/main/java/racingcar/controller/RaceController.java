package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.outputView = new OutputView();
        this.raceService = raceService;
    }

    public int findAttemptNum(String attemptNum) {
        return raceService.findAttemptNum(attemptNum);
    }

    public void startRace(List<Car> raceCars, int attemptNum) {
        Race race = new Race(raceCars, attemptNum);

        outputView.startOutput();

        for (int i = 0; i < race.getAttemptNum(); i++) {
            for (Car car : race.getRaceCars()) {
                car.occurRandomNum();
                raceService.checkAdvance(car);
                outputView.racingProgress(car);
            }
            outputView.blankLine();
        }
        racingResult(race.getRaceCars());
    }



    public void racingResult(List<Car> raceCars) {
        int maxAdvanceNum = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : raceCars) {
            if (car.getCountAdvance() > maxAdvanceNum) {
                maxAdvanceNum = car.getCountAdvance();
            }
        }

        for (Car car : raceCars) {
            if (car.getCountAdvance() == maxAdvanceNum) {
                winners.add(car.getName());
            }
        }

        outputView.racingResult(winners);

    }

}
