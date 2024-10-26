package racingcar.model.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.CarStatus;
import racingcar.model.car.Cars;

public class Game {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVEMENT_CRITERIA = 4;
    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private final Cars cars;
    private final TotalRounds totalRounds;
    private Winners winners;
    private int currentRound;

    public Game(Cars cars, int totalRounds) {
        validate(cars);

        this.cars = cars;
        this.totalRounds = new TotalRounds(totalRounds);
        this.currentRound = 1;
    }

    private void validate(Cars cars) {
        if (cars.hasFewerNumberOfCarsThan(MINIMUM_NUMBER_OF_CARS)) {
            throw new IllegalArgumentException("최소 2대 이상 출전해야 합니다.");
        }
    }

    public void play() {
        playNextRound();
        currentRound++;
    }

    private void playNextRound() {
        for (int index = 0; index < cars.getSize(); index++) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);

            if (randomNumber >= MOVEMENT_CRITERIA) {
                cars.move(index);
            }
        }
    }

    public boolean isPlaying() {
        return totalRounds.hasMoreRoundsThan(currentRound);
    }

    public void judgeWinners() {
        List<Car> maxPositionCars = cars.getMaxPositionCars();
        this.winners = new Winners(maxPositionCars);
    }

    public List<CarStatus> getStatusOfCars() {
        return cars.getStatus(currentRound);
    }

    public List<String> getNameOfWinners() {
        if (winners == null) {
            throw new IllegalArgumentException("아직 우승자들이 등록되지 않았습니다.");
        }
        return winners.getNamesOfWinner();
    }
}
