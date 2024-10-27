package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import racingcar.MoveEvent;
import racingcar.strategy.MoveStrategy;

public class RacingCars {

    private final MoveStrategy moveStrategy;
    private final List<RacingCar> racingCars;

    private RacingCars(MoveStrategy moveStrategy, List<RacingCar> racingCars) {
        this.moveStrategy = moveStrategy;
        this.racingCars = racingCars;
    }

    public void moveAll() {
        racingCars.forEach(this::move);
    }

    private void move(RacingCar racingCar) {
        if (moveStrategy.moveOrStop() == MoveEvent.MOVE) {
            racingCar.move();
        }
    }

    public List<RacingCar> getWinners() {
        Integer max = racingCars.stream()
            .map(RacingCar::getMoveCount)
            .max(Comparator.naturalOrder())
            .orElse(null);

        return racingCars.stream()
            .filter(racingCar -> Objects.equals(racingCar.getMoveCount(), max))
            .toList();
    }

    public void forEach(Consumer<RacingCar> action) {
        racingCars.forEach(action);
    }

    public static RacingCars of(MoveStrategy moveStrategy, List<String> carNames) {
        return new RacingCars(
            moveStrategy,
            carNames.stream()
                .map(RacingCar::from)
                .toList()
        );
    }

}
