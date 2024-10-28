package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.validator.CarRacingRepeatCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final CarRacingRepeatCountValidator carRacingRepeatCountValidator;


    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService, CarRacingRepeatCountValidator carRacingRepeatCountValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.carRacingRepeatCountValidator = carRacingRepeatCountValidator;
    }

    public void run() {
        String inputCarsName = inputView.inputCarsName();
        racingCarService.createRacingCars(inputCarsName);

        String inputCarRacingRepeatCount = inputView.inputCarRacingRepeatCount();
        carRacingRepeatCountValidator.validateRepeatCountNumberFormat(inputCarRacingRepeatCount);
        int integerCarRacingRepeatCount = Integer.parseInt(inputCarRacingRepeatCount);

        for (int i = 0; i < integerCarRacingRepeatCount; i++) {
            racingCarService.advanceRacingCar();
            List<String[]> extractedCarNameAndAdvanceResults = racingCarService.extractCarNameAndAdvanceResult();
            for (String[] carNameAndAdvanceResult : extractedCarNameAndAdvanceResults) {
                outputView.printCarRacingResult(carNameAndAdvanceResult[0], carNameAndAdvanceResult[1]);
            }
            outputView.printLineSpace();
        }

        String carRacingWInners = racingCarService.selectCarRacingWinners();
        outputView.printCarRacingWinner(carRacingWInners);
    }
}
