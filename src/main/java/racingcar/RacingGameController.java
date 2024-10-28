package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;
import racingcar.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void run() {
        UserInputData userInputData = initData();
        RacingResult racingResult = userInputData.startRacing();
        printResult(racingResult);
    }

    private static UserInputData initData() {
        List<Car> cars = Car.createByStrings(InputView.readStrings());
        int tryCount = InputView.readTryCount();

        return new UserInputData(cars, tryCount);
    }

    private static void printResult(RacingResult racingResults) {
        OutputView.printTryResult(racingResults.getCars());
        OutputView.printWinnerResult(racingResults.getWinners());
    }
}
