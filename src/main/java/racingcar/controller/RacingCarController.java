package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.ParsingCarNameService;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private ParsingCarNameService parsingCarNameService;

    public RacingCarController(ParsingCarNameService parsingCarNameService) {
        this.parsingCarNameService = parsingCarNameService;
    }

    public void startRacingGame() {
        String inputCarNames = InputView.inputCarName();
        List<Car> cars = ParsingCarNameService.parseCarNames(inputCarNames);

        int tryNum = InputView.inputTryNumber();

        RacingCarService racingCarService = new RacingCarService(cars);

        OutputView.printIntermediateText();
        for (int i = 0; i < tryNum; i++) {
            racingCarService.moveRacingCars();
            OutputView.printIntermediateResults(cars);
        }

        List<Car> winners = racingCarService.choiceWinner();
        OutputView.printFinalResults(winners);
    }
}
