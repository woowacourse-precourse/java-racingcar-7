package racingcar.controller;

import racingcar.model.CarRace;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void run() {
        String carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        CarRace carRace = new CarRace(carNames);
        OutputView.printStartMessage();

        for (int i = 0; i < rounds; i++) {
            carRace.moveCars();
            OutputView.printRoundResult(carRace.getCars());
        }

        OutputView.printWinners(Result.findWinners(carRace.getCars()));
    }
}