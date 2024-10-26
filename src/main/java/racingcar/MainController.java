package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    public static void run() {
        UserInputData userInputData = getCarNameAndTryCount();

        userInputData.tryingMoveCar();

        OutputView.printTryResult(userInputData.cars());
        OutputView.printWinnerResult(userInputData.getWinners());

    }

    private static UserInputData getCarNameAndTryCount() {
        List<Car> cars = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        UserInputData userInputData = new UserInputData(cars, tryCount);
        return userInputData;
    }
}
