package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    public RacingGame(List<String> carNames, int maxRound) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.maxRound = maxRound;
    }

    public HashMap<String, Integer> getState() {
        HashMap<String, Integer> state = new HashMap<>();
        for (Car car : cars) {
            state.put(car.getName(), car.getPosition());
        }
        return state;
    }

    public void play() {
        for (int i = 0; i < maxRound; i++) {
            processRound();
        }
    }

    private void processRound() {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }

    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars = new ArrayList<>();
    private final int maxRound;
}
