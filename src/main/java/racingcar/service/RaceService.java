package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.RaceProgress;
import racingcar.model.RaceResult;

import java.util.List;

public class RaceService {
    public RaceResult start(List<String> carNames, int attempts) {
        Cars cars = new Cars(carNames);
        RaceProgress raceProgress = new RaceProgress();

        for (int i = 0; i < attempts; i++) {
            cars.progressRound();
            raceProgress.addRoundPositions(cars.getPositions());
        }

        List<String> winners = cars.getWinners();
        return new RaceResult(raceProgress, winners);
    }
}