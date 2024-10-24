package racingcar.controller;

import static racingcar.util.InputValidator.validateNoDuplicates;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
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

        String[] carArray = inputCarsName.split(",");

        List<String> carList = Arrays.asList(carArray);
        validateNoDuplicates(carList);

        List<Car> cars = carList.stream()
                .map(car -> new Car(car, 0))
                .toList();
    }
}
