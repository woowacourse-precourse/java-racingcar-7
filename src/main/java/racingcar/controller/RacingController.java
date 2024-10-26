package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        OutputView.printInsertRacersName();
        String rawUserInput = InputView.getInputRacersName();
        OutputView.printInsertTryCount();
        String rawTryCount = InputView.getInputTryNumber();

        List<String> splittedRacersName = StringSplitter.splitByDelimiter(rawUserInput);
        List<CarName> rawCarNames = splittedRacersName.stream()
                .map(CarName::new)
                .toList();

        List<Car> rawCars = rawCarNames.stream().
                map(Car::new)
                .toList();

        Cars cars = new Cars(rawCars);

        RacingGame racingGame = new RacingGame(cars, rawTryCount);
        racingGame.runAllCycle();

        String racingResult = racingGame.getRacingResult();

        OutputView.printGameResultMessage();
        OutputView.printRacingResult(racingResult);

        List<String> FinalWinners = racingGame.getFinalWinner();
        OutputView.printFinalWinner(FinalWinners);
    }
}
