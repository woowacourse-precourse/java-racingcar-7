package racingcar.service;

import racingcar.model.RacingCarModel;
import java.util.List;
import java.util.Map;

public class RacingCarService {
    private final RacingCarModel model;

    public RacingCarService(RacingCarModel model) {
        this.model = model;
    }

    public Map<String, Integer> initializeCars(String carNames) {
        String[] carNameArray = model.SplitCarName(carNames);
        return model.setCarStatus(carNameArray);
    }

    public void progressRound(Map<String, Integer> raceStatus) {
        model.setProgress(raceStatus);
    }

    public List<String> getWinners(Map<String, Integer> raceStatus) {
        return model.findWinners(raceStatus);
    }
}

