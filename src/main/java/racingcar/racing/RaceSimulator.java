package racingcar.racing;

import static racingcar.io.OutputUtil.println;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        for (Car car : cars) {
            if (RandomNumberGenerator.getRandomNumber() >= 4) {
                car.moveCar();
            }
        }
    }

    private static String getRacingProgress(List<Car> cars) {
        StringBuilder racingProgress = new StringBuilder();

        for (Car car : cars) {
            racingProgress.append(car.getCarName()).append(" : ");
            for (long i = 0; i < car.getMoveDistance(); i++) {
                racingProgress.append("-");
            }
            racingProgress.append("\n");
        }

        return racingProgress.toString();
    }

    public static String getRacingWinner(List<Car> cars) {
        List<Car> copyCars = new ArrayList<>(cars);
        StringBuilder winners = new StringBuilder();
        int moveDistanceMax = getMoveDistanceMax(copyCars);

        winners.append(copyCars.getFirst().getCarName());
        for (int i = 1; i < copyCars.size(); i++) {
            Car car = copyCars.get(i);
            if (car.getMoveDistance() != moveDistanceMax) {
                break;
            }
            winners.append(", ").append(car.getCarName());
        }

        return winners.toString();
    }

    private static int getMoveDistanceMax(List<Car> cars) {
        cars.sort(Comparator.comparingInt(Car::getMoveDistance));
        return cars.getFirst().getMoveDistance();
    }
}
