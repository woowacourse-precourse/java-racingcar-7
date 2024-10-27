package racingcar;

import java.util.List;

public class RacingGame {
    private int MINIMUM_ROUND = 1;
    private int MINIMUM_NUMBER_OF_CAR = 2;

    private final int round;
    private List<Car> racingCars;

    public RacingGame(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (MINIMUM_ROUND > round) {
            throw new IllegalArgumentException("경주에 참여하려면 최소 1라운드 이상 설정해야 해요.");
        }

    }

    public void apply(List<Car> racingCars) {
        validateRacingCars(racingCars);
        this.racingCars = racingCars;
    }

    private void validateRacingCars(List<Car> racingCars) {
        if (MINIMUM_NUMBER_OF_CAR > racingCars.size()) {
            throw new IllegalArgumentException("경주에 참여할 자동차는 최소 2대 이상 있어야 해요.");
        }
    }
}
