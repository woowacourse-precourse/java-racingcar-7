package racingcar.controller;

import racingcar.model.dto.Car;
import racingcar.model.dto.RacingResult;
import racingcar.model.service.InputService;
import racingcar.model.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputService inputService;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, InputService inputService, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputService = inputService;
        this.racingService = racingService;
    }

    public void run() {
        inputView.inputViewCars();
        String cars = inputService.inputValue();
        inputView.inputViewCount();
        String attemptCount = inputService.inputValue();
        List<Car> carList = inputService.inputValidator(cars, attemptCount);
        List<RacingResult> racingResults = racingService.play(carList, Integer.parseInt(attemptCount));
        String winner = racingService.getPlayWinner();
        outputView.outputViewResult(racingResults);
        outputView.outputViewWinner(winner);
    }
}
