package racingcar.service;

import java.util.stream.IntStream;
import racingcar.domain.car.Cars;
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

    public void play() {
        OutputView.printResultMessage();
        IntStream.range(0, raceManager.getRaceCount()).forEach(i -> playOnce());
    }

    public void playOnce() {
        Cars cars = raceManager.playOnce();
        OutputView.printCarsWithPosition(cars);
    }
}
