package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        inputCarNames();
    }

    private void inputCarNames() {
        outputView.printInputCarNames();
        List<String> carNames = inputView.inputCarNames();
        List<Car> cars = creatCars(carNames);

        outputView.printInputRacingCount();
        int count = inputView.inputRacingCount();
        RacingCount racingCount = RacingCount.from(count);
    }

    private List<Car> creatCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(Car.from(carName));
        }
        return cars;
    }
}
