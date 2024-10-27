package racingcar.service;

import java.util.List;
import racingcar.dto.RacingResult;
import racingcar.model.Car;

public class RacingCarService {

    private static final int MINIMUM_GO_NUMBER = 4;

    public RacingResult startRacingGame(List<Car> cars, int tryCount) {

        StringBuilder racingResultBuilder = new StringBuilder();

        while (tryCount-- > 0) {
            moveCars(cars, racingResultBuilder);
        }

        List<String> winnerNames = generateWinnerResult(cars);

        return RacingResult.of(racingResultBuilder.toString(), winnerNames);
    }

    private void moveCars(List<Car> cars, StringBuilder racingResultBuilder) {

        for (Car car : cars) {
            if (RandomUtil.generateRandomNumber() >= MINIMUM_GO_NUMBER) {      // 전진
                car.go();
            }

            racingResultBuilder.append(car.getName()).append(" : ")
                    .append(car.getTrace()).append("\n");
        }
        racingResultBuilder.append("\n");
    }

    private List<String> generateWinnerResult(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(Car::getPos)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPos() == max)
                .map(Car::getName)
                .toList();
    }
}
