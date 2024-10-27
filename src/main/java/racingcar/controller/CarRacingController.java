package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.DriveStrategy;
import racingcar.model.TrialCount;
import racingcar.service.CarRacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {

    public static final String CAR_NAME_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final DriveStrategy driveStrategy;

    public CarRacingController(InputView inputView, OutputView outputView, DriveStrategy driveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.driveStrategy = driveStrategy;
    }

    public void run() {
        String carNames = inputView.inputCarNames();
        Cars racingCars = makeCarList(carNames);

        TrialCount trail = TrialCount.from(inputView.inputTrialCount());

        CarRacingService carRacingGame = new CarRacingService(racingCars, driveStrategy);

        outputView.printResultMessage();
        IntStream.range(0, trail.number()).forEach(ignored -> {
            carRacingGame.race();
            outputView.printRaceResult(racingCars);
        });

        List<Car> winner = carRacingGame.getWinner();
        outputView.printWinner(winner);
    }

    private Cars makeCarList(String carNames) {
        return Cars.from(Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList());
    }
}
