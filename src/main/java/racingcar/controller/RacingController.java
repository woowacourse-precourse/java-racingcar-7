package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingCount;
import racingcar.model.dto.CarStatusDto;
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
        inputCarNames();
    }

    private void inputCarNames() {
        outputView.printInputCarNames();
        List<String> carNames = inputView.inputCarNames();
        List<Car> carsList = creatCars(carNames);
        Cars cars = Cars.from(carsList);

        outputView.printInputRacingCount();
        int count = inputView.inputRacingCount();
        RacingCount racingCount = RacingCount.from(count);

        Racing racings = Racing.from(cars);
        outputView.printRacingResultMessage();
        while (isPossibleRacing(racingCount)) {
            racings.runRacing();
            racingCount.deduct();

            List<CarStatusDto> racingResults = racings.getResult();
            outputView.printRacingResult(racingResults);
        }

        List<String> winners = racings.getWinners();
        outputView.printWinner(winners);
    }

    private boolean isPossibleRacing(RacingCount racingCount) {
        return !racingCount.isEnd();
    }

    private List<Car> creatCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(Car.from(carName, new RandomNumberGenerator()));
        }
        return cars;
    }
}
