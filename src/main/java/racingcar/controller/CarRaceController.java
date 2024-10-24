package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.service.CarRaceService;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {

    private final CarRaceService carRaceService;
    private final InputView inputView;
    private final OutputView outputView;

    public CarRaceController(CarRaceService carRaceService, InputView inputView, OutputView outputView) {
        this.carRaceService = carRaceService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNames = inputView.inputCarNames();
        Validator.validateCarNames(carNames);
        String attempts = inputView.inputAttempts();
        carRaceService.init(carNames);

        outputView.printExecutionResultHeader();
        IntStream.range(0, Integer.parseInt(attempts))
                .forEach(attempt -> {
                    carRaceService.moveCars();
                    outputView.printCarsStatus(carRaceService.getCarsStatus());
                });

        outputView.printWinners(carRaceService.getWinners());
    }
}
