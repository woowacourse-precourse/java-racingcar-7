package service;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Race;
import domain.Car;
import domain.Cars;
import java.util.List;
import view.OutputView;

public class RacingService {

    public void race(Cars cars, int attempt) {
        for (int i = 0; i < attempt; i++) {
            moveCars(cars);
            OutputView.showRoundResult(cars);
        }
    }

    public List<String> getWinners(Cars cars) {
        int maxScore = getMaxScore(cars);

        return cars.getCarsList().stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();
    }

    private void moveCars(Cars cars) {
        for (Car car : cars.getCarsList()) {
            car.moveOrStop(getRandomNumber());
        }
    }

    private int getMaxScore(Cars cars) {
        return cars.getCarsList().stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Race.MIN_RANDOM_VALUE.getValue(), Race.MAX_RANDOM_VALUE.getValue());
    }
}
