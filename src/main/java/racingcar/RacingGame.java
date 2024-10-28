package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.io.InputConsoleHandler;
import racingcar.io.OutputConsoleHandler;
import racingcar.provider.NumberProvider;

public class RacingGame {

    private static final String POSITIONAL_CAR_STATUS_SYMBOL = "-";

    private final NumberProvider numberProvider;
    private final InputConsoleHandler inputConsoleHandler;
    private final OutputConsoleHandler outputConsoleHandler;

    public RacingGame(NumberProvider numberProvider, InputConsoleHandler inputConsoleHandler,
                      OutputConsoleHandler outputConsoleHandler) {
        this.numberProvider = numberProvider;
        this.inputConsoleHandler = inputConsoleHandler;
        this.outputConsoleHandler = outputConsoleHandler;
    }

    public void runGame() {
        inputConsoleHandler.showCarNameGuideMessage();
        Cars cars = Cars.of(inputConsoleHandler.askCarName());

        inputConsoleHandler.showNumOfTrialGuideMessage();
        int numOfTrial = inputConsoleHandler.askNumOfTrial();

        outputConsoleHandler.showResultPrefixMessage();
        progressTrials(numOfTrial, cars);

        showWinners(cars);
    }

    public void showCarsPositionalStatusForEachTrial(Cars cars) {
        String carsStatus = cars.changeCurrentTotalPositionalStatusToVisual(POSITIONAL_CAR_STATUS_SYMBOL);
        outputConsoleHandler.showCurrentCarStatus(carsStatus);
    }

    public void showWinners(Cars cars) {
        List<Car> winnerList = cars.findWinnerList();
        List<String> winnerNames = findWinnerNames(winnerList);

        outputConsoleHandler.showFinalWinnerNames(winnerNames);

    }

    public List<String> findWinnerNames(List<Car> winnerList) {
        List<String> winnerNameList = new ArrayList<>();
        winnerList.forEach(car -> car.provideNameIfWins(winnerList, winnerNameList));

        return winnerNameList;
    }

    private void progressTrials(int numOfTrial, Cars cars) {
        for (int numTry = 0; numTry < numOfTrial; numTry++) {
            cars.tryMoveForward(numberProvider);
            showCarsPositionalStatusForEachTrial(cars);
        }
    }
}
