package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.SequencedMap;

public class Game {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVEMENT_CRITERIA = 4;
    private final Cars cars;
    private int attemptCount;

    public Game(String[] carNames, int attemptCount) {
        this.cars = new Cars(carNames);
        this.attemptCount = attemptCount;
    }

    public void play() {
        attemptCount--;
        attemptToMoveCars();
    }

    private void attemptToMoveCars() {
        for (int index = 0; index < cars.getSize(); index++) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);

            if (randomNumber >= MOVEMENT_CRITERIA) {
                cars.move(index);
            }
        }
    }

    public boolean isRunning() {
        return attemptCount > 0;
    }

    public SequencedMap<String, Integer> getStatusOfCars() {
        return cars.getStatus();
    }
}
