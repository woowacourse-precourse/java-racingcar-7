package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    public static void run() {
        List<Car> cars = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        racingStart(tryCount, cars);
    }

    private static void racingStart(int inputTryCount, List<Car> cars) {
        tryMoveCars(inputTryCount, cars);
        OutputView.printTryResult(cars);
        OutputView.printWinnerResult(getWinners(cars));
    }

    private static void tryMoveCars(int inputTryCount, List<Car> cars) {
        IntStream.range(0, inputTryCount)
                .forEach((i) -> cars.forEach(car -> car.tryMove(if60PercentChance())));
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.get(0).getPosition();
        for (int i = 0; i < cars.size(); i++) {
            int comparedPosition = cars.get(i).getPosition();
            if (maxPosition < comparedPosition ) {
                maxPosition = comparedPosition;
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
    private static boolean if60PercentChance() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        if (pickNumberInRange >= 4) {
            return true;
        }
        return false;
    }
}
