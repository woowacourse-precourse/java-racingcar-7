package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.common.GameSettings;
import racingcar.model.Car;

public class RacingGameService {
    private final GameSettings gameSettings;

    public RacingGameService(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void race(Car car) {
        int pickedNumber = Randoms.pickNumberInRange(gameSettings.randomMinValue(),
                gameSettings.randomMaxValue());
        if (pickedNumber >= gameSettings.moveThreshold()) {
            car.move();
        }
    }

    public int getCurrentDistance(Car car) {
        return car.getDistance();
    }

    public List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
        for (Car car : cars) {
            if (car.isWinner(maxDistance)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
