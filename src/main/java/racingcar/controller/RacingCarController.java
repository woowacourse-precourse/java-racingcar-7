package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarName;
import racingcar.domain.Race;
import racingcar.util.TryCountConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        startRace(createCars(), getTryCount());
    }

    private CarName createCars() {
        return new CarName(getNameList(getCarNameInput()));
    }

    private int getTryCount() {
        TryCountConverter tryCountConverter = new TryCountConverter(getTryCountString());
        return tryCountConverter.stringToInt();
    }

    private String getTryCountString() {
        return inputView.printAskTryCount();
    }

    private void startRace(CarName carName, int tryCount) {
        Race race = new Race(tryCount, carName, outputView);
        race.raceStart();
    }

    public List<String> getNameList(String carName) {
        return Arrays.stream(carName.split(",", -1))
            .map(String::trim)
            .toList();
    }

    private String getCarNameInput() {
        return inputView.printAskCarName();
    }
}
