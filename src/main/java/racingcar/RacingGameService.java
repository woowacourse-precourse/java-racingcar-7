package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
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

}
