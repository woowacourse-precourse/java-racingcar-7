package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.util.RacingGameScoreBoard;

public final class RacingGame {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int ALLOWED_TO_MOVE_THRESHOLD = 4;

    private final RacingCars racingCars;
    private final int rounds;

    private RacingGame(RacingCars racingCars, int rounds) {
        this.racingCars = racingCars;
        this.rounds = rounds;
    }

    public static RacingGame of(RacingCars cars, int rounds) {
        return new RacingGame(cars, rounds);
    }

    public void start() {
        RacingGameScoreBoard.printTitle();
        for (int i = 0; i < rounds; i++) {
            nextRound();
        }
    }

    private void nextRound() {
        for (Car car : racingCars.getCars()) {
            car.forward(isCarAllowedToMove());
        }
        RacingGameScoreBoard.printCurrentScore(racingCars);
    }

    public void judge() {
        List<Car> cars = racingCars.getCars();

        Integer maxDistance = cars.stream()
                .map(Car::getDistance)
                .max(Comparator.naturalOrder())
                .orElseThrow();

        RacingCars winners = RacingCars.of(cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList());

        RacingGameScoreBoard.printWinners(winners);
    }

    private boolean isCarAllowedToMove() {
        int value = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

        return value >= ALLOWED_TO_MOVE_THRESHOLD;
    }
}
