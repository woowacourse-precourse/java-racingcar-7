package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    public static void run() {
        List<Car> cars = Car.createByStrings(InputView.readStrings());
        int tryCount = InputView.readTryCount();
        UserInputData userInputData = new UserInputData(cars, tryCount);

        userInputData.tryingMoveCars();

        OutputView.printTryResult(userInputData.getCars());
        OutputView.printWinnerResult(userInputData.getWinners());

    }
}
