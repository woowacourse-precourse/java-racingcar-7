package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        String inputCarsName = inputView.inputCarsName();
        int inputCarRacingRepeatCount = inputView.inputCarRacingRepeatCount();

        racingCarService.createRacingCars(inputCarsName);

        for (int i = 0; i < inputCarRacingRepeatCount; i++) {
            racingCarService.advanceRacingCarByRandomOrZero();
            List<String[]> extractedCarNameAndAdvanceResults = racingCarService.extractCarNameAndAdvanceResult();
            for (String[] carNameAndAdvanceResult : extractedCarNameAndAdvanceResults) {
                outputView.printCarRacingResult(carNameAndAdvanceResult[0], carNameAndAdvanceResult[1]);
            }
            outputView.printLineSpace();
        }
    }
}
