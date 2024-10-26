package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> participatingCars = new ArrayList<>();
    private final int attempts;

    public RacingGame(List<Car> carNames, int attempts) {
        for (Car name : carNames) {
            participatingCars.add(name);
        }
        this.attempts = attempts;
    }

    public void implement() {
        for (Car car : participatingCars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }
}
