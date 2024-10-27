package racingcar.racing;

import static racingcar.config.RandomNumberConfig.MOVE_STAND_NUMBER;
import static racingcar.io.OutputUtil.println;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.message.prompt.ResultPrompt;
import racingcar.util.RandomNumberGenerator;

public class RaceSimulator {
    private RaceSimulator() {
    }

    public static void startRace(List<Car> cars, long tryCount) {
        println(ResultPrompt.RESULT_PROMPT);

        while (tryCount-- > 0) {
            tryMoveCars(cars);
            println(getRacingProgress(cars));
        }
    }

    private static void tryMoveCars(List<Car> cars) {
        cars.stream()
                .filter(car -> RandomNumberGenerator.getRandomNumber() >= MOVE_STAND_NUMBER)
                .forEach(Car::moveCar);
    }

    private static String getRacingProgress(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCarName() + " : " + "-".repeat(car.getMoveDistance()))
                .collect(Collectors.joining("\n"));
    }

    public static String getRacingWinner(List<Car> cars) {
        List<Car> copyCars = new ArrayList<>(cars);
        int moveDistanceMax = getMoveDistanceMax(copyCars);
        return choseRacingWinner(copyCars, moveDistanceMax);
    }

    private static int getMoveDistanceMax(List<Car> cars) {
        cars.sort(Comparator.comparingInt(Car::getMoveDistance).reversed());
        return cars.getFirst().getMoveDistance();
    }

    private static String choseRacingWinner(List<Car> cars, int moveDistanceMax) {
        StringBuilder winners = new StringBuilder();

        winners.append(cars.getFirst().getCarName());
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getMoveDistance() != moveDistanceMax) {
                break;
            }
            winners.append(", ").append(car.getCarName());
        }

        return winners.toString();
    }
}
