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
        int pickedNumber = Randoms.pickNumberInRange(gameSettings.randomMinValue(), gameSettings.randomMaxValue());
        if (pickedNumber >= gameSettings.moveThreshold()) {
            car.move();
        }
    }

    public List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = Car.findMaxDistance(cars);
        for (Car car : cars) {
            String winnerName = car.getNameWinner(maxDistance);
            if (!winnerName.isEmpty()) {
                winners.add(winnerName);
            }
        }
        return winners;
    }
}
