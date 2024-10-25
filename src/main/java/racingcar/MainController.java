package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    public static void run() {
        List<Car> cars = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        racingStart(tryCount, cars);

        OutputView.printWinnerResult(getWinners(cars));

    }

    private static void racingStart(int inputTryCount, List<Car> cars) {
        tryMoveCars(inputTryCount, cars);
        OutputView.printTryResult(cars);
    }
    private static void tryMoveCars(int inputTryCount, List<Car> cars) {
        IntStream.range(0, inputTryCount)
                .forEach((i) -> cars.forEach(car -> car.tryMove(if60PercentChance())));
    }
    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .forEach(winners::add);

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
