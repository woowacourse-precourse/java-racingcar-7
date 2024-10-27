package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.io.OutputConsoleHandler;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

public class RacingGame {

    private static final String POSITIONAL_CAR_STATUS_SYMBOL = "-";

    private final NumberProvider numberProvider = new RandomNumberProvider();
    private final OutputConsoleHandler outputConsoleHandler = new OutputConsoleHandler();

    public void runGame(Cars cars) {

    }

    public void showCarsStatusForEachTrial(List<Car> cars) {

        for (Car car : cars) {
            String currentPositionalVisualStatus = car.changeCurrentPositionalStatusToVisual(
                    POSITIONAL_CAR_STATUS_SYMBOL);

            outputConsoleHandler.showCurrentCarStatus(currentPositionalVisualStatus);
        }

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
}
