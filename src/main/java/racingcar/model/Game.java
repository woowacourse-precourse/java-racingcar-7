package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVEMENT_CRITERIA = 4;
    private final Cars cars;
    private Winners winners;
    private int attemptCount;

    public Game(Cars cars, int attemptCount) {
        this.cars = cars;
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

    public List<CarStatus> getStatusOfCars() {
        return cars.getStatus();
    }

    public List<String> getNameOfWinners() {
        if (winners == null) {
            throw new IllegalArgumentException("아직 우승자들이 등록되지 않았습니다.");
        }
        return winners.getNamesOfWinner();
    }

    public void judgeWinners() {
        List<Car> maxPositionCars = cars.getMaxPositionCars();
        this.winners = new Winners(maxPositionCars);
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
