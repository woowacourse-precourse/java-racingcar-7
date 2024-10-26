package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    public static void run() {
        List<Car> cars = UserInputData.createCarByString(InputView.readStrings());
        int tryCount = InputView.readTryCount();

        UserInputData.tryingMoveCars(tryCount, cars);

        OutputView.printTryResult(cars);
        OutputView.printWinnerResult(UserInputData.getWinners(cars));

    }
}
