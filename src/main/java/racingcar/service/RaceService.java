package racingcar.service;

import racingcar.domain.race.RaceManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceService {

    private final RaceManager raceManager;

    public RaceService() {
        this.raceManager = new RaceManager();
    }

    public void setCars() {
        OutputView.printCarNamesMessage();
        String carNames = InputView.readCarNames();
        raceManager.setCars(carNames);
    }

    public void setRaceCount() {
        OutputView.printRaceCountMessage();
        String raceCount = InputView.readRaceCount();
        raceManager.setRaceCount(raceCount);
    }
}
