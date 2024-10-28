package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;

    public RacingController(final InputView inputView, final OutputView outputView, final StringParser stringParser) {
        this.inputView = inputView;
        this.outputView = new OutputView();
        this.stringParser = stringParser;
    }

    public void run() {
        List<Car> carList = getCarList(requestCarNameInputList());
        int tryCount = requestTryCountInput();

        Race race = new Race(outputView, carList, tryCount);
        race.startRace();
    }

    private List<String> requestCarNameInputList() {
        outputView.printCarNameInputRequest();
        final String carNameString = inputView.readCarName();

        return stringParser.parseCarNameString(carNameString);
    }

    private int requestTryCountInput() {
        outputView.printTryCountInputRequest();
        final String tryCountString = inputView.readTryCount();

        return stringParser.parseTryCountString(tryCountString);
    }

    private List<Car> getCarList(List<String> inputStringList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : inputStringList) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}
