package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Race;
import racingcar.utils.CarNameParser;
import racingcar.utils.RoundResultGenerator;
import racingcar.utils.WinnerDeterminer;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.util.List;

import static racingcar.view.output.OutputView.*;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printMessage(ASK_CAR_NAMES);
        String input = inputView.userInput();

        List<String> carNames = CarNameParser.parse(input);
        List<Car> cars = CarFactory.createCars(carNames);


        outputView.printMessage(ASK_TRY_COUNT);
        int tryCount = Integer.parseInt(inputView.userInput());

        startRace(cars, tryCount);
        determineWinners(cars);
    }

    private void startRace(List<Car> cars, int tryCount) {
        Race race = new Race(cars);

        outputView.printNewLine();
        outputView.printMessage(RESULT_TITLE);

        for (int round = 0; round < tryCount; round++) {
            race.start();

            List<String> roundResults = RoundResultGenerator.generate(cars);
            outputView.printRound(roundResults);
            outputView.printNewLine();
        }
    }

    private void determineWinners(List<Car> cars) {
        List<String> winnerList = WinnerDeterminer.getWinners(cars);

        outputView.printWinners(winnerList);
    }
}
