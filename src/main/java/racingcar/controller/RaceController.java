package racingcar.controller;

import java.util.List;
import racingcar.service.RaceService;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void run() {
        String userInput = inputView.CarNamesInput();
        int attemptsNum = inputView.attemptsNumInput();

        List<Car> cars = raceService.carListOf(userInput);

        outputView.showExecuteMessage();
        for (int attempt = 0; attempt < attemptsNum; attempt++) {
            raceService.forwardWithRandomCondition(cars);
            outputView.showStatus(cars);
        }

        List<String> winnersName = raceService.findWinners(cars);
        outputView.showWinners(winnersName);
    }
}
