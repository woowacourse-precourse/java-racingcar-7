package racingcar.controller;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TextFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final TextFormatter textFormatter;

    public Controller(InputView inputView, OutputView outputView, TextFormatter textFormatter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.textFormatter = textFormatter;
    }

    public void startRace() {
        try {
            Cars cars = initializeCars();
            runRaceRounds(cars);
            announceOfWinners(cars);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            throw (error);
        }
    }

    private Cars initializeCars() {
        String carNames = inputView.readCarNames();
        String[] carNameArr = textFormatter.splitCarNamesByComma(carNames);
        return Cars.from(carNameArr);
    }

    private void runRaceRounds(Cars cars) {
        int totalRounds = parseInt(inputView.readTotalRounds());
        Console.close();

        outputView.printRaceResultMessage();
        for (int round = 0; round < totalRounds; round++) {
            cars.advanceCarsRandomly();
            showRoundResults(cars);
        }
    }

    private void showRoundResults(Cars cars) {
        for (Car car : cars.getCars()) {
            String advanceMarkers = String.join("", car.getAdvanceMarkers());
            outputView.printRaceResult(car.getName(), advanceMarkers);
        }
        outputView.printBlankLine();
    }

    private void announceOfWinners(Cars cars) {
        int maxAdvanceMarkersCount = cars.getMaxAdvanceMarkerCount();
        List<Car> winners = cars.findWinners(maxAdvanceMarkersCount);
        String winnerNames = textFormatter.getWinnerNames(winners);
        outputView.printWinners(winnerNames);
    }
}