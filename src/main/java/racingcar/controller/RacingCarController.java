package racingcar.controller;

import static racingcar.view.InputView.getCarNameInput;
import static racingcar.view.InputView.getRoundCountInput;
import static racingcar.view.OutputView.printStartMessage;
import static racingcar.view.OutputView.printRoundResultOutput;
import static racingcar.view.OutputView.printWinnersOutput;
import static racingcar.utils.InputValidator.validateNullOrEmpty;
import static racingcar.utils.InputValidator.validateNumber;

import racingcar.domain.Cars;
import racingcar.domain.RoundCount;
import racingcar.domain.Winners;
import racingcar.domain.dto.CarsDto;
import racingcar.service.RacingCarService;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        String carNameInput = getCarNameInput();
        validateNullOrEmpty(carNameInput);
        Cars cars = racingCarService.createCars(carNameInput);

        String roundCountInput = getRoundCountInput();
        validateNullOrEmpty(roundCountInput);
        validateNumber(roundCountInput);
        RoundCount roundCount = racingCarService.getRoundCount(roundCountInput);

        printStartMessage();
        racingCarService.playRace(cars, roundCount);

        CarsDto carsDto = racingCarService.getCarsDto(cars);
        printRoundResultOutput(carsDto);

        Winners winners = racingCarService.getWinners(cars);
        printWinnersOutput(winners.getWinnersList());
    }
}
