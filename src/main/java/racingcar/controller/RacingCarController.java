package racingcar.controller;

import racingcar.domain.Message;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Result;
import racingcar.domain.race.RoundCount;
import racingcar.service.CarService;
import racingcar.service.MessageService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;
    private final RacingService racingService;
    private final MessageService messageService;

    public RacingCarController(InputView inputView, OutputView outputView, CarService carService,
                               RacingService racingService, MessageService messageService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
        this.racingService = racingService;
        this.messageService = messageService;
    }

    public void run() {
        inputView.printCarNameInputMessage();
        CarNames carNames = CarNames.from(inputView.getInput());
        inputView.printRoundCountInputMessage();
        RoundCount roundCount = RoundCount.from(inputView.getInput());

        Cars cars = carService.createCars(carNames);
        Result result = racingService.startRace(cars, roundCount);

        Message resultMessage = messageService.generateResultMessage(result);
        Message winnerMessage = messageService.generateWinnerMessage(cars);

        outputView.printResult(resultMessage);
        outputView.printWinner(winnerMessage);
        outputView.close();
    }
}
