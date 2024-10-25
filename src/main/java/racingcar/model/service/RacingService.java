package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.dto.Car;
import racingcar.model.dto.RacingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
    private List<Car> resultCars;

    public List<RacingResult> play(List<Car> cars, int attemptCount) {
        List<RacingResult> racingResults = new ArrayList<>();

        for (int i = 0; i < attemptCount; i++) {
            playAttemptCount(cars);
            racingResults.add(new RacingResult(new ArrayList<>(cars)));
        }
        resultCars = new ArrayList<>(cars);

        return racingResults;
    }

    public String getPlayWinner() {
        int maxMoveCount = resultCars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return resultCars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

    }

    public void playAttemptCount(List<Car> cars) {
        for (Car car : cars) {
            if (isPossibleMove()) {
                car.move();
            }
        }
    }

    private boolean isPossibleMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
