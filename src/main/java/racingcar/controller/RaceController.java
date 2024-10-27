package racingcar.controller;

import racingcar.model.Car;
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

        outputView.startOutput();
        for (int i = 0; i < attemptNum; i++) {
            for (Car car : raceCars) {
                car.occurRandomNum();
                raceService.checkAdvance(car);
                outputView.racingProgress(car);
            }
            outputView.blankLine();
        }
        racingResult(raceCars);
    }



    public void racingResult(List<Car> cars) {
        int maxAdvanceNum = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCountAdvance() > maxAdvanceNum) {
                maxAdvanceNum = car.getCountAdvance();
            }
        }

        for (Car car : cars) {
            if (car.getCountAdvance() == maxAdvanceNum) {
                winners.add(car.getName());
            }
        }

        outputView.racingResult(winners);

    }

}
