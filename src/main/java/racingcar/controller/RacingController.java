package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.RacingGame;
import racingcar.utils.RandomNumber;
import racingcar.utils.StringSplit;
import racingcar.utils.StringToInteger;
import racingcar.validation.NameValidator;
import racingcar.validation.NumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingGame = new RacingGame();
    }

    public void run() {
        List<Car> cars = getCars();
        int attempt = getAttempt();

        playGames(cars, attempt);
        List<String> winners = racingGame.findWinner(cars);
        outputView.printWinner(winners);
    }

    private List<Car> getCars() {
        String inputNameString = inputView.getUserInputNameString();
        List<String> names = StringSplit.stringSplitBySeparator(inputNameString);
        NameValidator.validateNameString(names);
        return Cars.createCars(names);
    }

    private int getAttempt() {
        String inputNumberString = inputView.getUserInputNumberString();
        NumberValidator.validateNumberString(inputNumberString);
        return StringToInteger.StringToIntegerConverter(inputNumberString);
    }

    private void playGames(List<Car> cars, int attempt) {
        outputView.printResultPrompt();
        for (int round = 0; round < attempt; round++) {
            List<Integer> randomNumbers = RandomNumber.createRandomNumber(cars.size());
            racingGame.startRace(cars,randomNumbers);
            outputView.printCurrentPosition(cars);
        }
    }
}
