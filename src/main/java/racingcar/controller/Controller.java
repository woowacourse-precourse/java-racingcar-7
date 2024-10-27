package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.service.RacingGameService;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;


    public Controller(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void startGame() {
        String rawInputCarNames = inputView.inputCarNames();
        List<String> carNames = Arrays.asList(rawInputCarNames.split(","));
        Validator.validateCarNames(carNames);

        List<Car> carList = CarFactory.createCarByName(carNames);

        String rawRoundInput = inputView.inputRoundNumber();
        Validator.validateRoundCount(rawRoundInput);
        int roundCount = Integer.parseInt(rawRoundInput);

        outputView.printExecutionResult();
        runGameForRounds(roundCount, carList);

        List<String> finalWinner = racingGameService.findFinalWinner(carList);
        outputView.printFinalRacingResult(finalWinner);
    }

    private void runGameForRounds(int repeatNumber, List<Car> carList) {
        for (int i = 0; i < repeatNumber; i++) {
            racingGameService.moveCars(carList);
            outputView.printCurrentRoundRacingResult(carList);
        }
    }


}
