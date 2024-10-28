package racingcar.model;

import java.util.List;
import java.util.Objects;

public class Game {
    private final Cars cars;
    private final Round round;

    private Game(List<String> carNames, int round) {
        validateDuplicatedCarName(carNames);
        this.cars = Cars.apply(carNames);
        this.round = Round.of(round);
    }

    public static Game start(List<String> carNames, int round) {
        return new Game(carNames, round);
    }

    private void validateDuplicatedCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        cars.playARound();
        round.proceed();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public boolean isGameEnd() {
        if (round.isZero()) {
            return true;
        }
        return false;
    }

    public List<String> getStatus() {
        return cars.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return Objects.equals(cars, game.cars) && Objects.equals(round, game.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, round);
    }
}
