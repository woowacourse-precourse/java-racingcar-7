package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVEMENT_CRITERIA = 4;
    private final Cars cars;
    private final TotalRounds totalRounds;
    private Winners winners;
    private int currentRound;

    public Game(Cars cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = new TotalRounds(totalRounds);
        this.currentRound = 1;
    }

    public void play() {
        attemptToMoveCars();
        currentRound++;
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
        return totalRounds.hasMoreRoundsThan(currentRound);
    }

    public void judgeWinners() {
        List<Car> maxPositionCars = cars.getMaxPositionCars();
        this.winners = new Winners(maxPositionCars);
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
}
