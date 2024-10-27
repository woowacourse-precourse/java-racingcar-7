package racingcar.racing;

import java.util.Comparator;
import java.util.List;
import racingcar.car.Car;
import racingcar.io.OutputUtil;
import racingcar.message.ResultPrompt;
import racingcar.util.RandomNumberGenerator;

public class RaceSimulator {
    private static final OutputUtil outputUtil = OutputUtil.getInstance();

    private RaceSimulator() {
    }

    public static void startRace(List<Car> cars, long tryCount) {
        outputUtil.println(ResultPrompt.RESULT_PROMPT);

        while (tryCount-- > 0) {
            tryMoveCars(cars);
            outputUtil.println(getRacingProgress(cars));
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
        StringBuilder winners = new StringBuilder();
        int moveDistanceMax = getMoveDistanceMax(cars);

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

    private static int getMoveDistanceMax(List<Car> cars) {
        cars.sort(Comparator.comparingInt(Car::getMoveDistance));
        return cars.getFirst().getMoveDistance();
    }
}
