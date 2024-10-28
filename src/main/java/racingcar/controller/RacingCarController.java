package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.validator.RacingCarRepeatCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final RacingCarRepeatCountValidator racingCarRepeatCountValidator;


    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService, RacingCarRepeatCountValidator racingCarRepeatCountValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.racingCarRepeatCountValidator = racingCarRepeatCountValidator;
    }

    public void run() {
        String inputCarsName = inputView.inputCarsName();
        racingCarService.createRacingCars(inputCarsName);

        String inputCarRacingRepeatCount = inputView.inputCarRacingRepeatCount();
        racingCarRepeatCountValidator.validateRepeatCountNumberFormat(inputCarRacingRepeatCount);
        int integerCarRacingRepeatCount = Integer.parseInt(inputCarRacingRepeatCount);

        for (int i = 0; i < integerCarRacingRepeatCount; i++) {
            racingCarService.advanceRacingCars();
            List<String[]> extractedCarNameAndAdvanceResults = racingCarService.getCarNamesAndAdvanceResults();
            for (String[] carNameAndAdvanceResult : extractedCarNameAndAdvanceResults) {
                outputView.printCarRacingResult(carNameAndAdvanceResult[0], carNameAndAdvanceResult[1]);
            }
            outputView.printLineSpace();
        }

        String carRacingWInners = racingCarService.selectCarRacingWinners();
        outputView.printCarRacingWinner(carRacingWInners);
    }
}
