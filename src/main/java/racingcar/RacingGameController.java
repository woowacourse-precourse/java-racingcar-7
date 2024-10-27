package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;
import racingcar.view.InputView;

public class RacingGameController {
    public static void run() {
        UserInputData userInputData = initData();
        userInputData.startRacing();
        userInputData.printResult();
    }

    private static UserInputData initData() {
        List<Car> cars = Car.createByStrings(InputView.readStrings());
        int tryCount = InputView.readTryCount();

        return new UserInputData(cars, tryCount);
    }
}
