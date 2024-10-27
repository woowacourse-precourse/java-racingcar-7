package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.RacingResult;
import racingcar.model.Car;

public class RacingCarService {

    private static final int MINIMUM_TRY_COUNT = 1;

    public RacingResult startRacingGame(List<Car> cars, int tryCount) {

        StringBuilder racingResultBuilder = new StringBuilder();

        while (tryCount-- >= MINIMUM_TRY_COUNT) {
            for (Car car : cars) {
                int ramdomNumber = Randoms.pickNumberInRange(0, 9);

                racingResultBuilder.append(car.getName()).append(" : ");
                if (ramdomNumber >= 4) {      // 전진
                    car.go();
                }
                for (int i = 0; i < car.getPos(); i++) {
                    racingResultBuilder.append("-");
                }
                racingResultBuilder.append("\n");
            }
            racingResultBuilder.append("\n");
        }

        List<String> winnerNames = generateWinnerResult(cars);

        return RacingResult.of(racingResultBuilder.toString(), winnerNames);
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
