package racingcar.controller;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputView inputView;

    public RacingController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> inputStringList = requestInputStringList();
    }

    private List<String> requestInputStringList() {
        List<String> inputStringList = new ArrayList<>();

        final String carNameString = inputView.readCarName();
        final String tryNumberString = inputView.readTryNumber();

        inputStringList.add(carNameString);
        inputStringList.add(tryNumberString);

        return inputStringList;
    }
}
