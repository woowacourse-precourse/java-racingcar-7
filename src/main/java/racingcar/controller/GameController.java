package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String inputCarsName = inputView.inputCarsName();
        int inputPlayCount = inputView.inputPlayCount();

        String[] cars = inputCarsName.split(",");
        List<String> list = Arrays.asList(cars);
        validateDuplicationCarName(list);

        for (String car : list) {
            validateNull(car);
            validateCarNameLength(car);
        }
    }

    private void validateNull(String car) {
        if (car.isBlank())
            throw new IllegalArgumentException();
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5)
            throw new IllegalArgumentException();
    }

    private void validateDuplicationCarName(List<String> carList) {
        for (String car : carList) {
            if (carList.contains(car))
                throw new IllegalArgumentException();
        }
    }
}
