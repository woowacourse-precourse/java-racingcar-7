package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.StringParser;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final StringParser stringParser;

    public RacingController(final InputView inputView, final StringParser stringParser) {
        this.inputView = inputView;
        this.stringParser = stringParser;
    }

    public void run() {
        List<String> inputStringList = requestInputStringList();
        List<Car> carList = getCarList(stringParser.parseCarNameString(inputStringList.getFirst()));
        int tryNumber = stringParser.parseTryNumberString(inputStringList.get(1));
    }

    private List<String> requestInputStringList() {
        List<String> inputStringList = new ArrayList<>();

        final String carNameString = inputView.readCarName();
        final String tryNumberString = inputView.readTryNumber();

        inputStringList.add(carNameString);
        inputStringList.add(tryNumberString);

        return inputStringList;
    }

    private List<Car> getCarList(List<String> inputStringList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : inputStringList) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}
