package racingcar.controller;

import java.util.Arrays;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TrialCount;
import racingcar.service.CarRacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {

    public static final String CAR_NAME_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final CarRacingService carRacingGame;

    public CarRacingController(InputView inputView, OutputView outputView, CarRacingService carRacingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carRacingGame = carRacingGame;
    }

    public void run() {
        String carNames = inputView.inputCarNames();
        Cars racingCars = createRacingCars(carNames);

        TrialCount trail = TrialCount.from(inputView.inputTrialCount());

        outputView.printResultMessage();
        IntStream.range(0, trail.number())
                .forEach(ignored ->
                        outputView.printRaceResult(carRacingGame.race(racingCars))
                );

        outputView.printWinner(carRacingGame.getWinner(racingCars));
    }

    private Cars createRacingCars(String carNames) {
        return Cars.from(Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList());
    }
}
