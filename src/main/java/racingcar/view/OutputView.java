package racingcar.view;

import static racingcar.view.OutputViewMessage.*;

import java.util.stream.Collectors;
import racingcar.car.Car;

import java.util.List;

public class OutputView {
    public static void carNameOutView() {
        System.out.println(PLEASE_INPUT_CAR_NAME);
    }

    public static void tryNumberOutView() {
        System.out.println(PLEASE_INPUT_TRY_NUMBER);
    }

    public static void excuteResult() {
        System.out.println(EXCUTE_RESULT_PRINT);
    }

    public static void resultPerTry(List<Car> racingCar) {
        String tryResult = racingCar.stream()
                .map(car -> car.getCarName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));
        System.out.println(tryResult + "\n");
    }

    public static void outputWinner(List<Car> winners) {
        String winnerResult = GAME_WINNER_PREFIX +
                winners.stream()
                        .map(Car::getCarName)
                        .collect(Collectors.joining(", "));
        System.out.println(winnerResult);
    }
}
