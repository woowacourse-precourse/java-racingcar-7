package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingCount;
import racingcar.util.randomnumber.RandomNumberGenerator;
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
        List<String> carNames = getInputCarNames();
        Cars cars = creatCars(carNames);

        int count = getInputRacingCount();
        RacingCount racingCount = RacingCount.from(count);

        Racing racing = Racing.of(cars, racingCount);

        runRacing(racing);
        disPlayWinner(racing);
    }

    private List<String> getInputCarNames() {
        outputView.printInputCarNames();
        return inputView.inputCarNames();
    }

    private int getInputRacingCount() {
        outputView.printInputRacingCount();
        return inputView.inputRacingCount();
    }

    private void runRacing(Racing racing) {
        outputView.printRacingResultMessage();
        while (racing.can()) {
            racing.run();
            racing.deductTryCount();

            outputView.printRacingResult(racing.getResult());
        }
    }

    private void disPlayWinner(Racing racing) {
        List<String> winners = racing.getWinners();
        outputView.printWinner(winners);
    }

    private Cars creatCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(Car.from(carName, new RandomNumberGenerator()));
        }
        return Cars.from(cars);
    }
}
